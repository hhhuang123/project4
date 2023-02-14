package pers.hhh.oneToAll;

import cn.edu.whu.graph.Network;
import cn.edu.whu.spa.splabel.SpLabel;
import cn.edu.whu.spa.IShortPathAlgorithm;
import cn.edu.whu.util.networkLoader.LoadNetFromCSV;

/**
 * @author hhhSir
 * @create 2022-10-06 18:30
 */
public class ShortPathAlg {
    public static void main(String[] args) throws Exception {
        String filePath = java.net.URLDecoder.decode("roadData\\xiamenNetworkLink2.csv", "utf-8");
        Network pNet = LoadNetFromCSV.loadNetWithCoordinate(filePath);

        IShortPathAlgorithm dijkstraAlg = ShortPathFactory.createShortPathFunction("aStar");

        SpLabel aimPath = dijkstraAlg.findShortPath(pNet, 398, 667);
        String linksInPath = aimPath.getLinksInPath();
        System.out.println(linksInPath);
        String nodesInPath = aimPath.getNodesInPath();
        System.out.println(nodesInPath);
        //
    }
}
