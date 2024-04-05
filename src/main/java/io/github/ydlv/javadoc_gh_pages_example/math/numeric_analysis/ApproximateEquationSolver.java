package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

/**
 * Approximate solver for finding a root of a function.
 */
public abstract class ApproximateEquationSolver {
    /**
     * The function for which to find a root
     */
    public final RealFunction function;

    /**
     * An upper bound on the difference between the real root
     * and the approximate root
     */
    public final double accuracy;

    /**
     * Creates an instance of {@link ApproximateEquationSolver}
     * @param function the function for which to find a root
     * @param accuracy an upper bound on the difference between the real root
     *                  and the approximate root
     */
    public ApproximateEquationSolver(RealFunction function, double accuracy) {
        this.function = function;
        this.accuracy = accuracy;
    }

    /**
     * Solves for the root of the function
     * @return an approximate root of the function,
     * at most {@link #accuracy} away from the real root.
     */
    public abstract double solve();
}
