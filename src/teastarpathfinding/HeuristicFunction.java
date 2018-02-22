package teastarpathfinding;

/**
 *
 * @author igor
 * @param <T> type of estimated value
 */

public interface HeuristicFunction<T> {
    public T evaluate(Vertex from, Vertex to);
}
