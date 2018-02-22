package teastarpathfinding;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author igor
 * Last edited 22-08-2018
 */

public class GraphVertexCoordinates {
    private Map<Vertex, Point2D<Double>> coords = new HashMap<>();
    
    public void set(Vertex vertex, double x, double y){
        coords.put(vertex, new Point2D(x, y));
    }
    
    public void set(Vertex vertex, Point2D<Double> position){
        coords.put(vertex, position);
    }
    
    public Point2D<Double> get(Vertex vertex){
        return coords.get(vertex);
    }
    
    public void remove(Vertex vertex){
        coords.remove(vertex);
    }
}
