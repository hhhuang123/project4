package cn.edu.whu.spa.splabel;

import cn.edu.whu.graph.base.INetLink;

/**
 * @author hhhSir
 * @create 2022-10-05 20:36
 */
public interface ISpLink extends INetLink {
    public double getLinkCost();

    public void updateLinkCost(double dblLinkCost);
}
