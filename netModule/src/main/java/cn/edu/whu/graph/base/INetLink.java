package cn.edu.whu.graph.base;

/**
 * @author hhhSir
 * @create 2022-09-19 22:15
 */
public interface INetLink {
    // region Properties
    INetNode getTailNode();

    int getTailNodeID();

    INetNode getHeadNode();

    int getHeadNodeID();

    int getLinkID();

    // endregion

    void release();
}
