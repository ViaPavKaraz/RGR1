public class FunctionWithParams implements MathFunction {
    private final double a;

    public FunctionWithParams(double a) {
        this.a = a;
    }

    @Override
    public double calculate(double x) {
        return Math.exp(-a * Math.pow(x, 2)) * Math.sin(x);
    }
}