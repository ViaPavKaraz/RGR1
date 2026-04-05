public class FunctionWithoutParams implements MathFunction {
    @Override
    public double calculate(double x) {
        return Math.exp(-Math.pow(x, 2)) * Math.sin(x);
    }
}