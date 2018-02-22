package teastarpathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author igor
 * Last edited 22-02-2018
 */

public class Graph {
    
    private final Map<Integer,Vertex> vertices = new HashMap<>();
    
    private final GraphVertexCoordinates vertexCoordinates = 
            new GraphVertexCoordinates();
    
    private final GraphWeightFunction weightFunction = 
            new GraphWeightFunction();
    
    private final HeuristicFunction<Double> euclideanHeuristicFunction =
            new EuclideanHeuristicFunction(vertexCoordinates);
    
    private final HeuristicFunction<Double> zeroHeuristicFunction =
            new ZeroHeuristicFunction();
    
    private List<Vertex> shortestPath = new ArrayList<>();
    
    private Map<Vertex, Double> shortestDistances = new HashMap<>();
    
    public List<Vertex> getShortestPath() {
        return Collections.unmodifiableList(shortestPath);
    }

    public Map<Vertex, Double> getShortestDistances() {
        return Collections.unmodifiableMap(shortestDistances);
    }
    
    public void addVertex(int id, double x, double y){
        Vertex vertex = new Vertex(id);
        vertices.put(id, vertex);
        Point2D<Double> position = new Point2D<>(x,y);
        vertexCoordinates.set(vertex, position);
    }
    
    public void removeVertex(int id){
        Vertex toRemove = vertices.get(id);
        if(toRemove != null){            
            toRemove.getNeighbours().forEach((v) -> {
                v.removeNeighbour(toRemove);
            });
            vertices.remove(id);
            vertexCoordinates.remove(toRemove);
        }
    }
    
    public void addEdge(int from, int to, double weight) {
        if (vertices.containsKey(from) && vertices.containsKey(to)) {
            vertices.get(from).addNeighbour(vertices.get(to));
            weightFunction.set(vertices.get(from), vertices.get(to), weight);
        }
    }
    
    public void removeEdge(int from, int to){
        if (vertices.containsKey(from) && vertices.containsKey(to)) {
            vertices.get(from).removeNeighbour(vertices.get(to));
            weightFunction.set(vertices.get(from), vertices.get(to),
                               Double.MAX_VALUE);
        }
    }
    
    public double findShortestDistanceAStar(int from, int to){
        shortestPath = AStarPathfinder.find(vertices.get(from),
                                                  vertices.get(to),
                                                  weightFunction,
                                                  euclideanHeuristicFunction,
                                                  vertexCoordinates);
        shortestDistances = AStarPathfinder.getLastShortestDistances();
        return shortestDistances.get(vertices.get(to));        
    }
    
    public double findShortestDistanceDijkstra(int from, int to){
        shortestPath = AStarPathfinder.find(vertices.get(from),
                                                  vertices.get(to),
                                                  weightFunction,
                                                  zeroHeuristicFunction,
                                                  vertexCoordinates);
        shortestDistances = AStarPathfinder.getLastShortestDistances();
        return shortestDistances.get(vertices.get(to));
    }
}
