import java.util.*;

public class TabularFunctionMap extends TabulatedFunction {
    private TreeMap<Double, Double> points = new TreeMap<>();

    public void addPoint(double x, double y) { points.put(x, y); }

    @Override
    public double calculate(double x) {
        if (points.isEmpty()) return 0;
        Map.Entry<Double, Double> low = points.floorEntry(x);
        Map.Entry<Double, Double> high = points.ceilingEntry(x);
        if (low == null) return high.getValue();
        if (high == null) return low.getValue();
        return interpolate(x, low.getKey(), low.getValue(), high.getKey(), high.getValue());
    }
}