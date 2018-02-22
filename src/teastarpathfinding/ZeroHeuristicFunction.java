package teastarpathfinding;

/**
 *
 * @author igor
 */

public class ZeroHeuristicFunction implements HeuristicFunction<Double>{
    private static final double ZERO = 0.0;
    @Override
    public Double evaluate(Vertex from, Vertex to) {
        return ZERO;
    }
    
}
