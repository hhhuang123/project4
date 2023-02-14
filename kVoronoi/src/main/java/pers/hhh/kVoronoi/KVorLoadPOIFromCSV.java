package pers.hhh.kVoronoi;

import cn.edu.whu.graph.Network;
import cn.edu.whu.graph.base.INetLink;
import cn.edu.whu.graph.base.INetNode;
import cn.edu.whu.spa.splabel.StaticLink;
import cn.edu.whu.spa.splabel.StaticNode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hhhSir
 * @create 2022-10-06 21:44
 */
public class KVorLoadPOIFromCSV {
    public static List<KVorNetLoc> getPOIs(String filepath, Network pNetwork) {
        List<KVorNetLoc> pois = new ArrayList<>();
        String inString ="";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            reader.readLine();

            while((inString=reader.readLine())!=null) {
                String item[] = inString.split(",");
                int poiID = new Integer(item[0]);
                double poiX = new Double(item[1]);
                double poiY = new Double(item[2]);
                int startID = new Integer(item[3]);
                int endID = new Integer(item[4]);
                double linear = new Double(item[5]);

                INetNode tailNode = pNetwork.getNetNode(startID);
                INetLink link = tailNode.getAdjacentLink(endID);
                KVorNetLoc tNetLoc = new KVorNetLoc(link, linear, poiID);
                pois.add(tNetLoc);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return pois;
    }
}
