package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

public abstract class ApproximateEquationSolver {
    public final RealFunction function;

    public final double accuracy;

    public ApproximateEquationSolver(RealFunction function, double accuracy) {
        this.function = function;
        this.accuracy = accuracy;
    }

    public abstract double solve();
}
