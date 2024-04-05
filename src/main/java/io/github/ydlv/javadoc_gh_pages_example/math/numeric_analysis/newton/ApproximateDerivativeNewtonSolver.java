package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.newton;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

public class ApproximateDerivativeNewtonSolver extends  NewtonMethodSolver {
    public final double dx;
    public ApproximateDerivativeNewtonSolver(RealFunction function, double accuracy, double x0, double dx) {
        super(function, accuracy, x0);
        this.dx = dx;
    }

    @Override
    protected double derivative(double x) {
        return (function.apply(x + dx) - function.apply(x)) / dx;
    }
}
