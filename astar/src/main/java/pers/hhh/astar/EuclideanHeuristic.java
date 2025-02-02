package pers.hhh.astar;

import cn.edu.whu.graph.Coordinate;
import cn.edu.whu.graph.base.INetNode;

/**
 * @author hhhSir
 * @create 2022-10-06 19:45
 */
public class EuclideanHeuristic implements IHeuristicFunction {
    private int destinationNodeId;
    private Coordinate destinationLoc;
    private double maxSpeed;

    public EuclideanHeuristic(int destinationNodeId, Coordinate destinationLoc, double maxSpeed) {
        if (destinationNodeId < 0) {
            throw new IllegalArgumentException("EuclideanHeuristic encounter an error: destinationNodeId < 0");
        }
        this.destinationNodeId = destinationNodeId;
        this.destinationLoc = destinationLoc;
        this.maxSpeed = maxSpeed;
    }

    public EuclideanHeuristic(INetNode destinationNode, double maxSpeed) {
        if (destinationNode == null) {
            throw new IllegalArgumentException("EuclideanHeuristic encounter an error: destinationNode == null");
        }
        if (destinationNode.getCoordinate() == null) {
            throw new IllegalArgumentException("EuclideanHeuristic encounter an error: destinationNode.getCoordinate() == null");
        }
        this.destinationNodeId = destinationNode.getNodeID();
        this.destinationLoc = destinationNode.getCoordinate();
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int getDestionationNodeID() {
        return this.destinationNodeId;
    }

    public Coordinate getDestinationLoc() {
        return this.destinationLoc;
    }

    @Override
    public double getHeuristicDistance(INetNode pNode) {
        if (pNode.getCoordinate() != null) {
            return Math.round(destinationLoc.cptEuclideanDistance(pNode.getCoordinate()) * 1000000 / this.maxSpeed) / 1000000.0;
        } else {
            return 0;
        }
    }
}
