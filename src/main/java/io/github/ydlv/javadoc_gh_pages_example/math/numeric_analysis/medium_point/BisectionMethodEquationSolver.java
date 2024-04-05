package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.medium_point;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

public class BisectionMethodEquationSolver extends MediumPointBasedEquationSolver {
    public BisectionMethodEquationSolver(RealFunction function, double a, double b, double accuracy) {
        super(function, a, b, accuracy);
    }

    @Override
    protected double middle(double a, double b) {
        return (a + b) / 2;
    }
}
