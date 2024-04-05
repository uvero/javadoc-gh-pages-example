package io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.medium_point;

import io.github.ydlv.javadoc_gh_pages_example.math.numeric_analysis.ApproximateEquationSolver;
import io.github.ydlv.javadoc_gh_pages_example.math.transformation.RealFunction;

/**
 * Solves the equation f(x) = 0 using a medium point method.
 * Different implementations differ by the way they calculate the middle point,
 * but all share the core logic of cutting the interval in half until
 * the desired accuracy is reached.
 */
public abstract class MediumPointBasedEquationSolver extends ApproximateEquationSolver {
    public final double a;
    public final double b;
    public MediumPointBasedEquationSolver(RealFunction function, double a, double b, double accuracy) {
        super(function, accuracy);
        this.a = a;
        this.b = b;
    }

    @Override
    public double solve() {
        double a = this.a, b = this.b;
        if(a > b) {
            double tmp = a;
            a = b;
            b = tmp;
        }

        double yA = function.apply(a);
        double yB = function.apply(b);
        if(yA == 0) {
            return a;
        }
        if(yB == 0) {
            return b;
        }
        if(yA * yB > 0) {
            throw new IllegalArgumentException("Root not bracketed");
        }

        while(b - a > accuracy) {
            double c = middle(a, b);
            double yC = function.apply(c);
            if(yC == 0) {
                return c;
            }
            if(yC * yA < 0) {
                b = c;
            } else {
                a = c;
                yA = yC;
            }
        }
        return a;
    }

    protected abstract double middle(double a, double b);
}
