package cn.edu.whu.spa.splabel;

import cn.edu.whu.graph.base.INetNode;

/**
 * @author hhhSir
 * @create 2022-10-05 20:38
 */
public interface ISpNode extends INetNode {
    SpLabel getLabel();

    void setLabel(SpLabel spLabel);

    void setSPID(int sPID);

    boolean isDifferentSPID(int SPID);
}
