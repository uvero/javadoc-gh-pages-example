package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.newton;

import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

public class KnownDerivativeNewtonSolver extends NewtonMethodSolver {
    public final RealFunction derivative;


    public KnownDerivativeNewtonSolver(RealFunction function, RealFunction derivative, double accuracy, double x0) {
        super(function, accuracy, x0);
        this.derivative = derivative;
    }

    @Override
    protected double derivative(double x) {
        return derivative.apply(x);
    }

}
