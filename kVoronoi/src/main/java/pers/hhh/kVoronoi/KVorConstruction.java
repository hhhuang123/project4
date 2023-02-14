package pers.hhh.kVoronoi;

import cn.edu.whu.graph.Network;
import cn.edu.whu.graph.base.INetLink;
import cn.edu.whu.graph.base.INetNode;
import cn.edu.whu.spa.splabel.SpLabel;
import cn.edu.whu.spa.splabel.StaticLink;
import cn.edu.whu.spa.splabel.ISpLink;
import cn.edu.whu.spa.splabel.ISpNode;
import cn.edu.whu.util.FibonacciHeap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author hhhSir
 * @create 2022-10-06 21:32
 */
public class KVorConstruction {

    public static void calculateKNN(Network pNetwork, List<KVorNetLoc> pois, int k) {
        FibonacciHeap<KVorLabel> fh = new FibonacciHeap<>();
        final Map<KVorLabel, FibonacciHeap.Entry<KVorLabel>> heapEntries = new HashMap<>();
        // 初始化
        Iterator<INetNode> nodes = pNetwork.iterator();
        while (nodes.hasNext()) {
            KVorNode t = (KVorNode) nodes.next();
            t.initialize(pois.size());
        }

        final Map<Integer, Integer> poiToIDX = new HashMap<>();
        for (int i = 0; i < pois.size(); i++) {
            KVorNetLoc kVorNetLoc = pois.get(i);
            // 拿到各个属性
            int poi = kVorNetLoc.getPoi();
            StaticLink netLink = (StaticLink) kVorNetLoc.getINetLink();
            double lrs = kVorNetLoc.getiLRS();
            KVorNode headNode = (KVorNode) netLink.getHeadNode();
            KVorNode tailNode = (KVorNode) netLink.getTailNode();
            // 构建一个点\两条边\两个label
            INetNode locNode = new KVorNode(poi);
            StaticLink tailLink = new StaticLink(locNode, tailNode, -1, lrs * netLink.getLinkCost());
            StaticLink headLink = new StaticLink(locNode, headNode, -1, (1 - lrs) * netLink.getLinkCost());
            KVorLabel locLabel = new KVorLabel((ISpNode) locNode, 0);
            // 扩展为两个label
            KVorLabel tailLabel = new KVorLabel((ISpNode) tailNode, tailLink.getLinkCost(), tailLink, locLabel, 0, poi);
            KVorLabel headLabel = new KVorLabel((ISpNode) headNode, headLink.getLinkCost(), headLink, locLabel, 0, poi);

            heapEntries.put(tailLabel, fh.enqueue(tailLabel, tailLabel.getPathCost()));
            heapEntries.put(headLabel, fh.enqueue(headLabel, headLabel.getPathCost()));
            poiToIDX.put(poi, i);
        }

        KVorLabel pChosenLabel, pAdjacentLabel;
        KVorNode pChosenNode, pAdjacentNode;
        ISpLink pAdjacentLink;

        while (!fh.isEmpty()) {
            pChosenLabel = fh.dequeueMin().getValue();
            pChosenNode = (KVorNode) pChosenLabel.getAssociatedNode();
            if (pChosenNode.getKLabelSize() >= k) {
                continue;
            }

            int poi = pChosenLabel.getPoi();
            int i = poiToIDX.get(poi);

            pChosenNode.addKLabels(pChosenLabel);

            Iterator<INetLink> linkIterator = pChosenNode.iterator();

            while (linkIterator.hasNext()) {
                pAdjacentLink = (ISpLink) linkIterator.next();
                pAdjacentNode = (KVorNode) pAdjacentLink.getHeadNode();

                SpLabel spLabel = pChosenLabel.expandAcylic(true, pAdjacentLink, 0);
                if (spLabel == null) {
                    continue;
                }
                pAdjacentLabel = new KVorLabel(spLabel);
                pAdjacentLabel.setPoi(pChosenLabel.getPoi());


                if (pAdjacentLabel != null) {
                    if (pAdjacentNode.getNLabels(i) == null) {
                        pAdjacentNode.setNLabels(i, pAdjacentLabel);
                        heapEntries.put(pAdjacentLabel, fh.enqueue(pAdjacentLabel, pAdjacentLabel.getPathCost()));
                    } else {
                        if (pAdjacentNode.getNLabels(i).getPathCost() > pAdjacentLabel.getPathCost()) {
                            fh.delete(heapEntries.get(pAdjacentNode.getNLabels(i)));
                            pAdjacentNode.setNLabels(i, pAdjacentLabel);
                            heapEntries.put(pAdjacentLabel, fh.enqueue(pAdjacentLabel, pAdjacentLabel.getPathCost()));
                        }
                    }
                }
            }
            if (pChosenNode.getKLabelSize() == k) {
                pChosenNode.setClosed(true);
            }
        }
    }

    public static void saveKNN(Network pNetwork, String filePath) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(filePath));
            Iterator<INetNode> iterator = pNetwork.iterator();
            while(iterator.hasNext()) {
                KVorNode node = (KVorNode) iterator.next();
                ArrayList<KVorLabel> kVorLabels = node.getkLabels();
                // nodeID, poi1, dist1, poi2, dist2, poi3, dist3, ...
                StringBuilder sb = new StringBuilder(node.getNodeID() + ",");
                for (int i = 0; i < kVorLabels.size(); i++) {
                    sb.append(kVorLabels.get(i).getPoi());
                    sb.append(',');
                    sb.append(kVorLabels.get(i).getPathCost());
                    sb.append(',');
                }
                out.write(sb.toString() + "\r\n");
            }
        } catch (IOException e) {
            throw new IOException("saveKNN encounter an error：IOException");
        } finally {
            out.close();
        }
    }

}
