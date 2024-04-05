package io.github.ydlv.javadoc_gh_pages_example.math.transformation;

import io.github.ydlv.javadoc_gh_pages_example.math.cartesian_plane.Point;

/**
 * Represents a real-valued function.
 */
public interface RealFunction {

    /**
     * Applies this function to the specified argument.
     *
     * @param x real number
     * @return {@code f(x)}
     */
    double apply(double x);

    /**
     * Returns a point on the curve of this function at the specified x-coordinate.
     * @param x x-coordinate
     * @return (x, f(x)) as a {@link Point} object
     */
    default Point at(double x) {
        return new Point(x, apply(x));
    }

    /**
     * Returns a new function that is the sum of this function and the specified y-coordinate.
     * @param dy a number
     * @return the function x -> f(x) + dy
     */
    default RealFunction plus(double dy) {
        return (x) -> apply(x) + dy;
    }

    /**
     * Returns a new function that is the difference of this function and the specified y-coordinate.
     * @param dy a number
     * @return the function x -> f(x) - dy
     */
    default RealFunction minus(double dy) {
        return (x) -> apply(x) - dy;
    }

    /**
     * Returns a new function that is the product of this function and the specified scalar.
     * @param scalar a number
     * @return the function x -> f(x) * scalar
     */
    default RealFunction times(double scalar) {
        return (x) -> apply(x) * scalar;
    }
}
