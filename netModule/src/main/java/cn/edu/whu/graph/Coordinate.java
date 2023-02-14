package cn.edu.whu.graph;

/**
 * @author hhhSir
 * @create 2022-09-19 20:45
 */
public class Coordinate {
    public double x;
    public double y;

    public Coordinate(double dblX, double dblY) {
        this.x = dblX;
        this.y = dblY;
    }

    /**
     * 计算欧氏距离
     * @param pCoordinate
     * @return
     */
    public double cptEuclideanDistance(Coordinate pCoordinate) {
        return Math.sqrt(Math.pow(pCoordinate.x - this.x, 2) + Math.pow(pCoordinate.y - this.y, 2));
    }
}
