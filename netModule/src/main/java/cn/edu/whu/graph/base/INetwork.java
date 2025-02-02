package cn.edu.whu.graph.base;

/**
 * @author hhhSir
 * @create 2022-09-19 22:07
 */
public interface INetwork extends Iterable<INetNode> {
    // region Properties
    int getNodeCount();

    int getLinkCount();

    NetworkType getNetType();

    boolean hasTurn();

    boolean hasCoordinate();

    boolean hasTollDistance();

    boolean hasShortestPaths();

    boolean hasMaxSpeed();

    double getMaxSpeed();

    boolean hasMaxLinkLength();

    double getMaxLinkLength();

    int getSPID();

    boolean addNewSPID();
    // endregion

    // region Methods

    /**
     * 判断节点是否存在
     * @param iNodeID
     * @return
     */
    boolean isNodeExists(int iNodeID);

    /**
     * 获取节点
     * @param iNodeID
     * @return
     */
    INetNode getNetNode(int iNodeID);

    /**
     * 判断边是否存在
     * @param iTailNodeID
     * @param iHeadNodeID
     * @return
     */
    boolean isLinkExists(int iTailNodeID, int iHeadNodeID);

    /**
     * 获取边
     * @param iTailNodeID
     * @param iHeadNodeID
     * @return
     */
    INetLink getNetLink(int iTailNodeID, int iHeadNodeID);

    /**
     * 添加节点
     * @param iNodeID
     * @param pNetNode
     */
    void addNode(int iNodeID, INetNode pNetNode);

    /**
     * 删除节点
     * @param iNodeID
     */
    void removeNode(int iNodeID);

    /**
     * 释放内存
     */
    void release();
    // endregion
}
