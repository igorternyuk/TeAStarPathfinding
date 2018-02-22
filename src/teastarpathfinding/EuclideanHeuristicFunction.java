package teastarpathfinding;

/**
 *
 * @author igor
 */

public class EuclideanHeuristicFunction implements HeuristicFunction<Double>{
    private final GraphVertexCoordinates coords;
    
    public EuclideanHeuristicFunction(GraphVertexCoordinates coords){
        this.coords = coords;
    }
    
    @Override
    public Double evaluate(Vertex from, Vertex to) {
        Point2D<Double> fromPosition = coords.get(from);
        Point2D<Double> toPosition = coords.get(to);
        return fromPosition.distanceTo(toPosition);
    }
    
}
