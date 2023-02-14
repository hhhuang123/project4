package pers.hhh.dijkstra;

import cn.edu.whu.graph.Network;
import cn.edu.whu.graph.base.INetLink;
import cn.edu.whu.spa.IShortPathAlgorithm;
import cn.edu.whu.spa.splabel.ISpLink;
import cn.edu.whu.spa.splabel.ISpNode;
import cn.edu.whu.spa.splabel.SpLabel;
import cn.edu.whu.spa.splabel.StaticNode;
import cn.edu.whu.util.FibonacciHeap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hhhSir
 * @create 2022-10-05 21:55
 */
public class DijkstraSPA implements IShortPathAlgorithm {
    int originID;
    int destionationID;

    @Override
    public int getOriginNode() {
        return this.originID;
    }

    @Override
    public void setOriginNode(int originNodeID) {
        this.originID = originNodeID;
    }

    @Override
    public int getDestinationNode() {
        return this.destionationID;
    }

    @Override
    public void setDestinationNode(int destinationNodeID) {
        this.destionationID = destinationNodeID;
    }

    @Override
    public SpLabel findShortPath(Network pNetwork, int iOrigin, int iDestination) {
        if (pNetwork == null) {
            throw new IllegalArgumentException("StaticSPA dijkstraFHeap encounters an error. input network should not be null");
        }
        if (!pNetwork.isNodeExists(iOrigin)) {
            throw new IllegalArgumentException("StaticSPA dijkstraFHeap encounters an error. input iOrigin should not be null");
        }
        if (!pNetwork.isNodeExists(iDestination)) {
            throw new IllegalArgumentException("StaticSPA dijkstraFHeap encounters an error. input iDestination should not be null");
        }

        FibonacciHeap<SpLabel> fh = new FibonacciHeap<>();

        // 初始化
        final Map<SpLabel, FibonacciHeap.Entry<SpLabel>> heapEntries = new HashMap<>();
        StaticNode oriNode = (StaticNode) pNetwork.getNetNode(iOrigin);
        SpLabel oriLabel = new SpLabel(oriNode, 0);
        oriNode.setLabel(oriLabel);
        heapEntries.put(oriLabel, fh.enqueue(oriLabel, 0));

        SpLabel pChosenLabel, pAdjacentLabel;
        ISpNode pChosenNode, pAdjacentNode;
        ISpLink pAdjacentLink;

        while (!fh.isEmpty()) {
            pChosenLabel = fh.dequeueMin().getValue();
            // 找到了目的地，返回一个label
            if (iDestination == pChosenLabel.getAssociatedNode().getNodeID()) {
                return pChosenLabel;
            }
            // 扩展路径
            pChosenNode = pChosenLabel.getAssociatedNode();
            pChosenNode.getAdjacentLinkCount();
            Iterator<INetLink> adjacentLinkIter = pChosenNode.iterator();
            while (adjacentLinkIter.hasNext()) {
                pAdjacentLink = (ISpLink) adjacentLinkIter.next();
                pAdjacentNode = (ISpNode) pAdjacentLink.getHeadNode();

                pAdjacentLabel = pChosenLabel.expandAcylic(true, pAdjacentLink, 0);

                if (pAdjacentLabel != null) {
                    if (pAdjacentNode.getLabel() == null) {
                        pAdjacentNode.setLabel(pAdjacentLabel);
                        heapEntries.put(pAdjacentLabel, fh.enqueue(pAdjacentLabel, pAdjacentLabel.getPathCost()));
                    } else {
                        if (pAdjacentLabel.getPathCost() < pAdjacentNode.getLabel().getPathCost()) {
                            fh.delete(heapEntries.get(pAdjacentNode.getLabel()));
                            pAdjacentNode.setLabel(pAdjacentLabel);
                            heapEntries.put(pAdjacentLabel, fh.enqueue(pAdjacentLabel, pAdjacentLabel.getPathCost()));
                        }
                    }
                }
            }
        }
        return null;
    }
}
