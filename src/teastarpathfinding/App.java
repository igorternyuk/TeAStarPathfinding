package teastarpathfinding;

import java.util.List;

/**
 *
 * @author igor
 */

public class App {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
    // TODO code application logic here
        
        Graph graph = new Graph();
        graph.addVertex(1, 2.0, 4.5);
        graph.addVertex(2, 3.5, 3.0);
        graph.addVertex(3, 4.5, 7.0);
        graph.addVertex(4, 6.5, 4.0);
        graph.addVertex(5, 9.0, 5.0);
        graph.addVertex(6, 7.0, 8.0);
        
        graph.addEdge(1, 2, 3.0);
        graph.addEdge(1, 4, 13.0);
        graph.addEdge(1, 3, 5.0);
        graph.addEdge(2, 4, 7.0);
        graph.addEdge(3, 4, 6.0);
        graph.addEdge(4, 5, 8.0);
        graph.addEdge(4, 6, 7.0);
        graph.addEdge(5, 6, 2.0);
        graph.addEdge(6, 3, 10.0);
        
            
        System.out.println("AStar pathfinding\n");
        long start1 = System.nanoTime();
        for(int i = 2; i <= 6; ++i){
            double shortestDistance = graph.findShortestDistanceAStar(1, i);
            List<Vertex> shortestPath = graph.getShortestPath();
            System.out.println("Shortest distance from 1 to " + i + ":" + shortestDistance);
            System.out.println("Shortest path from 1 to " + i + ":");
            shortestPath.forEach(v -> {
                System.out.println(v);
            });
        }
        long end1 = System.nanoTime();
        System.out.println("Calculation time = " + ((end1 - start1) / 1000000.0) + " ms. \n");
        
        System.out.println("Dijkstra pathfinding\n");
        long start2 = System.nanoTime();
        for(int i = 2; i <= 6; ++i){
            double shortestDistance = graph.findShortestDistanceDijkstra(1, i);
            List<Vertex> shortestPath = graph.getShortestPath();
            System.out.println("Shortest distance from 1 to " + i + ":" + shortestDistance);
            System.out.println("Shortest path from 1 to " + i + ":");
            shortestPath.forEach(v -> {
                System.out.println(v);
            });
        }
        long end2 = System.nanoTime();
        System.out.println("Calculation time = " + ((end2 - start2) / 1000000.0) + " ms. \n");
        
    }
    
}
