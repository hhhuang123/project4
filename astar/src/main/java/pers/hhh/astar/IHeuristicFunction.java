package pers.hhh.astar;

import cn.edu.whu.graph.base.INetNode;

/**
 * @author hhhSir
 * @create 2022-10-06 19:43
 */
public interface IHeuristicFunction {
    int getDestionationNodeID();
    double getHeuristicDistance(INetNode pNode);
}
