package teastarpathfinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author igor
 * Last edited 22-02-2018
 */

public class AStarPathfinder {
    private static Map<Vertex, Double> distances = new HashMap<>();

    public static Map<Vertex, Double> getLastShortestDistances() {
        return Collections.unmodifiableMap(distances);
    }
    
    private static final class HeapEntry implements Comparable<HeapEntry> {

        Vertex vertex;
        double distance;

        public HeapEntry(Vertex vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public Vertex getVertex() {
            return vertex;
        }

        public void setVertex(Vertex vertex) {
            this.vertex = vertex;
        }

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        @Override
        public int compareTo(HeapEntry other) {
            return Double.compare(this.distance, other.getDistance());
        }

    }

    public static List<Vertex> find(Vertex source, Vertex target,
            GraphWeightFunction weightFunction,
            HeuristicFunction<Double> heuristicFunction,
            GraphVertexCoordinates coordinates) {

        Queue<HeapEntry> queue = new PriorityQueue<>();
        Set<Vertex> alreadyVisited = new HashSet<>();
        distances.clear();
        Map<Vertex, Vertex> parents = new HashMap<>();

        //Fisrt of all we will push the source vertex with zero distance to the queue
        queue.add(new HeapEntry(source, 0.0));
        distances.put(source, 0.0);
        parents.put(source, null); // Source vertex has no currentVertex

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.poll().getVertex();
            if (currentVertex.equals(target)) {
                return restoreShortestPath(target, parents);
            }
            
            if(currentVertex.getId() == 4){
                System.out.println("");
            }

            if (!alreadyVisited.contains(currentVertex)) {
                currentVertex.getNeighbours().stream()
                        .filter((neighbour) -> (!alreadyVisited.contains(neighbour)))
                        .forEachOrdered((neighbour) -> {
                            double tmpDistance = distances.get(currentVertex)
                                    + weightFunction.get(currentVertex, neighbour);
                            if (!distances.containsKey(neighbour)
                                    || tmpDistance < distances.get(neighbour)) {
                                distances.put(neighbour, tmpDistance);
                                parents.put(neighbour, currentVertex);
                                tmpDistance += heuristicFunction.evaluate(neighbour, target);
                                queue.add(new HeapEntry(neighbour, tmpDistance));
                            }
                        });
                alreadyVisited.add(currentVertex);
            }
        }

        return new ArrayList<>();
    }

    private static List<Vertex> restoreShortestPath(Vertex target,
            Map<Vertex, Vertex> parents) {
        List<Vertex> path = new ArrayList<>();
        Vertex currentVertex = target;
        while (currentVertex != null) {
            path.add(currentVertex);
            currentVertex = parents.get(currentVertex);
        }
        Collections.reverse(path);
        return Collections.unmodifiableList(path);
    }
}
