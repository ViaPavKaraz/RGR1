import java.util.*;
abstract class AbstractTabularFunction implements MathFunction {
    protected double interpolate(double x, double x1, double y1, double x2, double y2) {
        return y1 + (y2 - y1) * (x - x1) / (x2 - x1);
    }
}