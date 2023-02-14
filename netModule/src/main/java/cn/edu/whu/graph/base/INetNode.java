package cn.edu.whu.graph.base;

import cn.edu.whu.graph.Coordinate;

import java.util.Map;

/**
 * @author hhhSir
 * @create 2022-09-19 22:14
 */
public interface INetNode extends Iterable<INetLink>{
    // region Properties
    int getNodeID();

    int getAdjacentLinkCount();

    boolean hasCoordinate();

    Coordinate getCoordinate();

    Map<Integer, INetLink> getPredecessorLinks();

    Map<Integer, INetLink> getAdjacentLinks();
    // endregion

    // region Method

    /**
     * 判断是否存在后继边
     * @param headNodeID
     * @return
     */
    boolean hasAdjacentLink(int headNodeID);

    /**
     * 获取后继边
     * @param headNodeID
     * @return
     */
    INetLink getAdjacentLink(int headNodeID);

    void release();

    void addAdjacentLink(INetLink pAdjacentLink);

    void removeAdjacentLink(int headNodeID);

    void addPredecessorLink(INetLink pPredecessorLink);

    void removePredecessorLink(int tailNodeID);

    // endregion
}
