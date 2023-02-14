package cn.edu.whu.spa;

import cn.edu.whu.graph.Network;
import cn.edu.whu.spa.splabel.SpLabel;

/**
 * @author hhhSir
 * @create 2022-10-06 10:25
 */
public interface IShortPathAlgorithm {
    int getOriginNode();
    void setOriginNode(int originNodeID);
    int getDestinationNode();
    void setDestinationNode(int destinationNodeID);

    SpLabel findShortPath(Network pNetwork, int iOrigin, int iDestination);
}
