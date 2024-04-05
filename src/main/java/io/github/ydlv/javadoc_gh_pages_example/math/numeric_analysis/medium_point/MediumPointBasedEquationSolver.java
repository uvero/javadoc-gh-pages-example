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
    /**
     * The left endpoint of the interval to be searched
     */
    public final double a;
    /**
     * The right endpoint of the interval to be searched
     */
    public final double b;

    /**
     * Creates an instance of {@link MediumPointBasedEquationSolver}
     * @param function the function for which to find a root
     * @param a the left endpoint of the interval to be searched
     * @param b the right endpoint of the interval to be searched
     * @param accuracy an upper bound on the difference between the real root
     *                  and the approximate root
     */
    public MediumPointBasedEquationSolver(RealFunction function, double a, double b, double accuracy) {
        super(function, accuracy);
        this.a = a;
        this.b = b;
    }

    /**
     * Solves for the root of the function in the interval [a, b]
     * @return an approximate root of the function.
     * See {@link ApproximateEquationSolver#solve()}
     */
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

    /**
     * Finds a middle point in the interval [left, right]
     * @param left a left endpoint
     * @param right a right endpoint
     * @return a point in the interval of [left, right]
     */
    protected abstract double middle(double left, double right);
}
