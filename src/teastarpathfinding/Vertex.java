package teastarpathfinding;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author igor
 */

public class Vertex {
    private final int id;
    private final Set<Vertex> neighbours = new HashSet<>();

    public Vertex(int id) {
        this.id = id;
    }
    
    public void addNeighbour(Vertex vertex){
        neighbours.add(vertex);
    }
    
    public void removeNeighbour(Vertex vertex){
        neighbours.remove(vertex);
    }
    
    public int getId() {
        return id;
    }

    public Set<Vertex> getNeighbours() {
        return Collections.unmodifiableSet(neighbours);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        final Vertex other = (Vertex) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Vertex{" + "id=" + id + '}';
    }
}
