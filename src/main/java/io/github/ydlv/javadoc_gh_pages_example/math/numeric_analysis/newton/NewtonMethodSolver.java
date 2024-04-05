package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.newton;

import io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.ApproximateEquationSolver;
import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

/**
 * Solves for the root of a function using Newton's method.
 */
public abstract class NewtonMethodSolver extends ApproximateEquationSolver {
    /**
     * The initial guess for the root
     */
    public final double x0;

    /**
     * Creates an instance of {@link NewtonMethodSolver}
     * @param function the function for which to find a root
     * @param accuracy an upper bound on the difference between the real root
     *                  and the approximate root
     * @param x0 the initial guess
     */
    public NewtonMethodSolver(RealFunction function, double accuracy, double x0) {
        super(function, accuracy);
        this.x0 = x0;
    }

    /**
     * Solves for the root of the function using Newton's method.
     * @return an approximate root of the function, at most
     * {@link #accuracy} away from the real root
     */
    @Override
    public double solve() {
        double x = x0;
        double y = function.apply(x);
        double xPrev = Double.POSITIVE_INFINITY;
        while(Math.abs(x - xPrev) > accuracy) {
            xPrev = x;
            x = x - y / derivative(x);
            y = function.apply(x);
        }
        return x;
    }

    /**
     * Returns the derivative of the function at the given point
     * @param x a point at which to calculate derivative.
     * @return the derivative of the function
     */
    protected abstract double derivative(double x);
}
