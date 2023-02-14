package cn.edu.whu.graph.base;

/**
 * @author hhhSir
 * @create 2022-09-19 22:05
 */
public enum NetworkType {
    NT_Static(1),
    NT_Dynamic(2),
    NT_Stochastic(3),
    NT_Normal(4),
    NT_StochasticDyanmic(5),
    NL_StoDynamicSpeed(6);

    private int value;
    NetworkType(int i) {
        this.value = i;
    }
}
