package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.newton;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

/**
 * Solves for the root of a function using Newton's method
 * and an approximate derivative.
 */
public class ApproximateDerivativeNewtonSolver extends  NewtonMethodSolver {
    /**
     * A small differential for the approximate derivative.
     */
    public final double dx;

    /**
     * Creates an instance of {@link ApproximateDerivativeNewtonSolver}
     * @param function the function for which to find a root
     * @param accuracy an upper bound on the difference between the real root
     *                 and the approximate root
     * @param x0 the initial guess
     * @param dx a small differential that is used to approximate the derivative.
     *           It should be small enough so that (f(x+dx)-f(x))/dx
     *           is a good approximation of the derivative, but not
     *           too small to avoid numerical instability.
     */
    public ApproximateDerivativeNewtonSolver(RealFunction function, double accuracy, double x0, double dx) {
        super(function, accuracy, x0);
        this.dx = dx;
    }

    /**
     * Approximates the derivative of the function using the specified
     * differential.
     * @param x the x-coordinate of the point where we want to approximate the derivative
     * @return the approximate derivative
     */
    @Override
    protected double derivative(double x) {
        return (function.apply(x + dx) - function.apply(x)) / dx;
    }
}
