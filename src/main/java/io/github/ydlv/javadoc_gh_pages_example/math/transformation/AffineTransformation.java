package io.github.ydlv.javadoc_gh_pages_example.math.transformation;

import io.github.ydlv.javadoc_gh_pages_example.math.cartesian_plane.Point;

/**
 * Represents an affine transformation (AKA linear function).
 * Affine transformation: y = slope * x + yIntercept
 */
public class AffineTransformation implements RealFunction {
    /**
     * The slope of this affine transformation.
     */
    public final double slope;

    /**
     * The y-intercept of this affine transformation.
     * f(0) = yIntercept
     */
    public final double yIntercept;

    /**
     * Creates an affine transformation with the specified slope and y-intercept.
     * @param slope the slope of this affine transformation
     * @param yIntercept the y-intercept of this affine transformation
     */
    public AffineTransformation(double slope, double yIntercept) {
        this.slope = slope;
        this.yIntercept = yIntercept;
    }

    /**
     * Calculates the value of this affine transformation at the specified argument.
     * See {@link RealFunction#apply(double)}
     * @param x real number
     * @return {@code slope * x + yIntercept}
     */
    @Override
    public double apply(double x) {
        return slope * x + yIntercept;
    }

    /**
     * Calculates the x-intercept of this affine transformation.
     * @return the x-intercept of this affine transformation. NaN if the slope is 0
     */
    public double xIntercept() {
        if(slope == 0) {
            return Double.NaN;
        }
        return -yIntercept / slope;
    }

    /**
     * Returns an affine transformation between two points.
     * @param p1 a point through which the affine transformation passes
     * @param p2 another point through which the affine transformation passes
     * @return an affine transformation that passes between the two points
     */

    public static AffineTransformation between(Point p1, Point p2) {
        double slope = (p2.y - p1.y) / (p2.x - p1.x);
        double yIntercept = p1.y - slope * p1.x;
        return new AffineTransformation(slope, yIntercept);
    }

    /**
     * Returns an affine transformation that passes through the specified point with the specified slope.
     * @param p a point through which the affine transformation passes
     * @param slope the slope of the affine transformation
     * @return an affine transformation that passes through the specified point with the specified slope
     */
    public static AffineTransformation viaPointWithSlope(Point p, double slope) {
        double yIntercept = p.y - slope * p.x;
        return new AffineTransformation(slope, yIntercept);
    }


    /**
     * Returns an affine transformation that is
     * equal to this one minus the specified number.
     * @param dy a number
     * @return the affine transformation that is x -> f(x) - dy
     */
    @Override
    public AffineTransformation minus(double dy) {
        return new AffineTransformation(slope, yIntercept - dy);
    }

    /**
     * Returns an affine transformation that is
     * equal to this one plus the specified number.
     * @param dy a number
     * @return the affine transformation that is x -> f(x) + dy
     */
    @Override
    public AffineTransformation plus(double dy) {
        return new AffineTransformation(slope, yIntercept + dy);
    }

    /**
     * Returns an affine transformation that is
     * equal to this one times the specified y-coordinate.
     * @param scalar a number
     * @return the affine transformation that is x -> f(x) * scalar
     */
    @Override
    public AffineTransformation times(double scalar) {
        return new AffineTransformation(slope * scalar, yIntercept * scalar);
    }
}
