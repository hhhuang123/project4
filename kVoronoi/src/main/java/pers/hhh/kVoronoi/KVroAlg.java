package pers.hhh.kVoronoi;

import cn.edu.whu.graph.Network;
import cn.edu.whu.util.networkLoader.LoadNetFromCSV;

import java.util.List;

/**
 * @author hhhSir
 * @create 2022-10-07 15:06
 */
public class KVroAlg {
    public static void main(String[] args) throws Exception {
        String netFilePath = java.net.URLDecoder.decode("roadData\\szNetwork.csv", "utf-8");
        String poiFilePath = java.net.URLDecoder.decode("roadData\\szSuper.csv", "utf-8");
        String saveFilePath = java.net.URLDecoder.decode("roadData\\k5dist.csv", "utf-8");
        Network pNet = KVorLoadNetFromCSV.loadNetWithCoordinate(netFilePath);
        List<KVorNetLoc> pois = KVorLoadPOIFromCSV.getPOIs(poiFilePath, pNet);
        int k = 5;
        KVorConstruction.calculateKNN(pNet, pois, k);
        KVorConstruction.saveKNN(pNet, saveFilePath);
        System.out.println("成功计算");
    }
}
