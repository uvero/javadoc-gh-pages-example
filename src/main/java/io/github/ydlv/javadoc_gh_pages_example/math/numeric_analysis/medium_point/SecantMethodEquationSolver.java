package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.medium_point;

import io.github.ydlv.javadoc_gh_pages_example.math.cartesian_plane.Point;
import io.github.ydlv.javadoc_gh_pages_example.math.transformation.AffineTransformation;
import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

/**
 * Solves for the root of a function using secant method.
 * See {@link MediumPointBasedEquationSolver}
 */
public class SecantMethodEquationSolver extends MediumPointBasedEquationSolver {
    /**
     * Creates an instance of {@link SecantMethodEquationSolver}
     * @param function the function for which to find a root
     * @param a the left endpoint of the interval to be searched
     * @param b the right endpoint of the interval to be searched
     * @param accuracy an upper bound on the difference between the real root
     *                  and the approximate root
     */
    public SecantMethodEquationSolver(RealFunction function, double a, double b, double accuracy) {
        super(function, a, b, accuracy);
    }

    /**
     * Finds a point between left and right
     * by finding the y-intercept
     * of the line segment passing through
     * (left, y(left)) and (right, y(right))
     * @param left a left endpoint
     * @param right a right endpoint
     * @return a point in the interval of [left, right]
     * that is the y-intercept of the line segment.
     */
    @Override
    protected double middle(double left, double right) {
        double yA = function.apply(left);
        double yB = function.apply(right);
        Point a = new Point(left, yA);
        Point b = new Point(right, yB);
        AffineTransformation transformation = AffineTransformation.between(a, b);
        return transformation.xIntercept();
    }

}
