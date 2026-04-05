import edu.hws.jcm.data.*;

public class ParserFunction implements MathFunction {
    private Parser parser;
    private Variable xVar, aVar;
    private Expression expression, derivativeExpr;

    public ParserFunction(String formula, double aValue) {
        parser = new Parser();
        xVar = new Variable("x"); aVar = new Variable("a");
        parser.add(xVar); parser.add(aVar);
        aVar.setVal(aValue);
        expression = parser.parse(formula);
        derivativeExpr = expression.derivative(xVar);
    }

    @Override
    public double calculate(double x) {
        xVar.setVal(x);
        return expression.getVal();
    }

    public double calculateSymbolicDerivative(double x) {
        xVar.setVal(x);
        return derivativeExpr.getVal();
    }
}