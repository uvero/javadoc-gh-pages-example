package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.newton;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

/**
 * Uses a known derivative to solve for the root of a function
 * using Newton's method, when the derivative is known and is provided
 * by the user
 */
public class KnownDerivativeNewtonSolver extends NewtonMethodSolver {

    /**
     * This function is provided by the user upon initialization.
     * It should be the derivative of the function for which to find
     * a root.
     */
    public final RealFunction derivative;

    /**
     * Creates an instance of {@link KnownDerivativeNewtonSolver}
     * @param function the function for which to find a root
     * @param derivative the derivative of the function
     * @param accuracy an upper bound on the difference between the real root
     *                 and the approximate root
     * @param x0 the initial guess
     */
    public KnownDerivativeNewtonSolver(RealFunction function, RealFunction derivative, double accuracy, double x0) {
        super(function, accuracy, x0);
        this.derivative = derivative;
    }

    /**
     * Calculates the derivative of the function using
     * the function that is provided by the user upon initialization.
     * @param x the x-coordinate of the point where we want to calculate the derivative
     * @return the approximate derivative
     */
    @Override
    protected double derivative(double x) {
        return derivative.apply(x);
    }

}
