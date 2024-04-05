package io.github.ydlv.javadoc_gh_pages_example.math.cartesian_plane;

/**
 * Represents a point in 2D space.
 */
public class Point {
    /**
     * The x-coordinate of this point.
     */
    public final double x;

    /**
     * The y-coordinate of this point.
     */
    public final double y;

    /**
     * Creates a new point with the specified coordinates.
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
    public static Point polar(double r, double theta) {
        return new Point(r * Math.cos(theta), r * Math.sin(theta));
    }
    
    public double getAzimuth() {
        return Math.atan2(y, x);
    }
    
    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }
}
