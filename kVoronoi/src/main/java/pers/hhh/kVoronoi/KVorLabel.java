package pers.hhh.kVoronoi;

import cn.edu.whu.graph.base.INetLink;
import cn.edu.whu.spa.splabel.SpLabel;
import cn.edu.whu.spa.clabel.CLabel;
import cn.edu.whu.spa.splabel.ISpNode;

/**
 * @author hhhSir
 * @create 2022-10-06 21:21
 */
public class KVorLabel extends SpLabel {
    private int poi;

    public int getPoi() {
        return poi;
    }

    public void setPoi(int poi) {
        this.poi = poi;
    }


    public KVorLabel(SpLabel spLabel) {
        super(spLabel.getAssociatedNode(), spLabel.getPathCost(), spLabel.getLink(), (CLabel) spLabel.getPrevious(), spLabel.getDblHCost());
    }

    public KVorLabel(ISpNode pAssociateNode, double iPathCost, INetLink link, CLabel previous, double dblHCost) {
        super(pAssociateNode, iPathCost, link, previous, dblHCost);
    }

    public KVorLabel(ISpNode pAssociateNode, double iPathCost, INetLink link, CLabel previous, double dblHCost, int poi) {
        super(pAssociateNode, iPathCost, link, previous, dblHCost);
        this.poi = poi;
    }

    public KVorLabel(ISpNode pAssociateNode, double dblHCost) {
        super(pAssociateNode, dblHCost);
    }
}
