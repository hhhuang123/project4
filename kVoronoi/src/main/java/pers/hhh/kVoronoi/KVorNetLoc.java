package pers.hhh.kVoronoi;

import cn.edu.whu.graph.NetLocation;
import cn.edu.whu.graph.base.INetLink;

/**
 * @author hhhSir
 * @create 2022-10-06 21:38
 */
public class KVorNetLoc extends NetLocation {
    int poi;

    public int getPoi() {
        return poi;
    }

    public void setPoi(int poi) {
        this.poi = poi;
    }

    public KVorNetLoc(INetLink pNetLink, double iLRS) {
        super(pNetLink, iLRS);
    }

    public KVorNetLoc(INetLink pNetLink, double iLRS, int poi) {
        super(pNetLink, iLRS);
        this.poi = poi;
    }
}
