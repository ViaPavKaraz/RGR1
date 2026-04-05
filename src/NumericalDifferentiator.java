public class NumericalDifferentiator implements Differentiator {
    @Override
    public double derive(MathFunction function, double x, double precision) {
        return (function.calculate(x + precision) - function.calculate(x)) / precision;
    }
}