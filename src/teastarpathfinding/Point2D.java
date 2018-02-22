package teastarpathfinding;

import java.util.Objects;

/**
 *
 * @author igor
 * @param <T> type of coordinates
 */

public class Point2D<T> {
    private T x;
    private T y;
    
    public Point2D(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
    
    public double distanceTo(Point2D<T> other){
        double x1 = (Double)this.x;
        double y1 = (Double)this.y;
        double x2 = (Double)other.y;
        double y2 = (Double)other.y;        
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    
    public double lineAngle(Point2D<T> other){
        double x1 = (Double)this.x;
        double y1 = (Double)this.y;
        double x2 = (Double)other.y;
        double y2 = (Double)other.y;
        return Math.atan2(y2 - y1, x2 - x1);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.x);
        hash = 13 * hash + Objects.hashCode(this.y);
        return hash;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        final Point2D<?> other = (Point2D<?>) that;
        return Objects.equals(this.x, other.x) && 
               Objects.equals(this.y, other.y);
    }

    @Override
    public String toString() {
        return "Point2D{" + "x=" + x + ", y=" + y + '}';
    }
}
