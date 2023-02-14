package pers.hhh.kVoronoi;

import cn.edu.whu.graph.base.INetLink;
import cn.edu.whu.graph.base.INetNode;
import cn.edu.whu.spa.splabel.StaticNode;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author hhhSir
 * @create 2022-10-06 21:14
 */
public class KVorNode extends StaticNode {
    private ArrayList<KVorLabel> nLabels;
    private ArrayList<KVorLabel> kLabels;
    private boolean isClosed;

    public KVorNode(int iNodeID, Map<Integer, INetLink> pAdjacentLinks, Map<Integer, INetLink> pPredecessorLinks) {
        super(iNodeID, pAdjacentLinks, pPredecessorLinks);
        this.nLabels = new ArrayList<>();
        this.kLabels = new ArrayList<>();
        isClosed = false;
    }

    public KVorNode(int pNodeID, double x, double y, Map<Integer, INetLink> pAdjacentLinks, Map<Integer, INetLink> pPredecessorLinks) {
        super(pNodeID, x, y, pAdjacentLinks, pPredecessorLinks);
        this.nLabels = new ArrayList<>();
        this.kLabels = new ArrayList<>();
        isClosed = false;
    }

    public KVorNode(INetNode node) {
        super(node.getNodeID(), node.getCoordinate().x, node.getCoordinate().y,
                node.getAdjacentLinks(), node.getPredecessorLinks());
        this.nLabels = new ArrayList<>();
        this.kLabels = new ArrayList<>();
        isClosed = false;
    }



    public KVorNode(int pNodeID) {
        super(pNodeID);
        this.nLabels = new ArrayList<>();
        this.kLabels = new ArrayList<>();
        isClosed = false;
    }

    public KVorNode(int pNodeID, double x, double y) {
        super(pNodeID, x, y);
        this.nLabels = new ArrayList<>();
        this.kLabels = new ArrayList<>();
        isClosed = false;
    }

    public void initialize(int n) {
        for (int i = 0; i < n; i++) {
            this.nLabels.add(null); // arrayList是允许空值的
        }
        isClosed = false;
    }

    public void setNLabels(int i, KVorLabel newLabel) {
        this.nLabels.set(i, newLabel);
    }

    public KVorLabel getNLabels(int i) {
        return this.nLabels.get(i);
    }

    public void addKLabels(KVorLabel newLabel) {
        this.kLabels.add(newLabel);
    }

    public int getKLabelSize() {
        return this.kLabels.size();
    }

    public boolean isClosed() {
        return this.isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public ArrayList<KVorLabel> getkLabels() {
        return this.kLabels;
    }
}
