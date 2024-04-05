package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.newton;

import io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.ApproximateEquationSolver;
import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

public abstract class NewtonMethodSolver extends ApproximateEquationSolver {
    public final double x0;

    public NewtonMethodSolver(RealFunction function, double accuracy, double x0) {
        super(function, accuracy);
        this.x0 = x0;
    }

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

    protected abstract double derivative(double x);
}
