package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.medium_point;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

/**
 * Solves for the root of a function using bisection.
 * See {@link MediumPointBasedEquationSolver}
 */
public class BisectionMethodEquationSolver extends MediumPointBasedEquationSolver {
    /**
     * Creates an instance of {@link BisectionMethodEquationSolver}
     * @param function the function for which to find a root
     * @param a the left endpoint of the interval to be searched
     * @param b the right endpoint of the interval to be searched
     * @param accuracy an upper bound on the difference between the real root
     *                  and the approximate root
     */
    public BisectionMethodEquationSolver(RealFunction function, double a, double b, double accuracy) {
        super(function, a, b, accuracy);
    }

    /**
     * Finds the middle point of the interval. See
     * {@link MediumPointBasedEquationSolver#middle(double, double)}
     * @param left a left endpoint
     * @param right a right endpoint
     * @return the middle point between left and right
     */
    @Override
    protected double middle(double left, double right) {
        return (left + right) / 2;
    }
}
