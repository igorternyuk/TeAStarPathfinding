package teastarpathfinding;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author igor
 */

public class GraphWeightFunction {
    private final Map<Vertex, Map<Vertex, Double>> map = new HashMap<>();
    
    public void set(Vertex from, Vertex to, double weight){
        map.putIfAbsent(from, new HashMap<>());
        map.get(from).put(to, weight);
    }
    
    public double get(Vertex from, Vertex to){
        if(map.containsKey(from)){
            return map.get(from).get(to);
        } else {
            return Double.MAX_VALUE;
        }
    }
}
