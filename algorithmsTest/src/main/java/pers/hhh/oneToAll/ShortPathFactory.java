package pers.hhh.oneToAll;

import cn.edu.whu.spa.IShortPathAlgorithm;
import pers.hhh.astar.AStarSPA;
import pers.hhh.dijkstra.DijkstraSPA;

/**
 * @author hhhSir
 * @create 2022-10-06 10:31
 */
public class ShortPathFactory {
    public static IShortPathAlgorithm createShortPathFunction(String algorithm) {
        IShortPathAlgorithm spa = null;
        switch (algorithm) {
            case "dijkstra":
                spa = new DijkstraSPA();
                break;
            case "aStar":
                spa = new AStarSPA();
                break;
        }
        return spa;
    }
}
