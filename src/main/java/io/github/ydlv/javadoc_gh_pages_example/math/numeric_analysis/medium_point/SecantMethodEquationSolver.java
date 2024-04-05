package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.medium_point;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

public class SecantMethodEquationSolver extends MediumPointBasedEquationSolver {
    public SecantMethodEquationSolver(RealFunction function, double a, double b, double accuracy) {
        super(function, a, b, accuracy);
    }

    @Override
    protected double middle(double a, double b) {
        double yA = function.apply(a);
        double yB = function.apply(b);
        return a - yA * (b - a) / (yB - yA);
    }

}
