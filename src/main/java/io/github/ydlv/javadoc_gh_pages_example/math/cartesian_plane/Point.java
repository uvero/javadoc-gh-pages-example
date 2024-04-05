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

    /**
     * Returns a representation of this point as a string.
     * @return "(" + x + ", " + y + ")"
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Returns a point with the specified polar coordinates.
     * @param r the distance of the point from the origin
     * @param theta the angle of the point from the x-axis
     * @return the point at this polar coordinates
     */
    public static Point polar(double r, double theta) {
        return new Point(r * Math.cos(theta), r * Math.sin(theta));
    }

    /**
     * Calculates the azimuth of this point (the angle in radians
     * from the x-axis)
     * @return the azimuth in radians
     */
    public double getAzimuth() {
        return Math.atan2(y, x);
    }

    /**
     * Calculates the magnitude of this point
     * @return the magnitude of this point, i.e. the distance
     * from this point to the origin
     */
    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }
}
