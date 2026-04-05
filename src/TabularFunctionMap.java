import java.util.*;
public class TabularFunctionMap extends AbstractTabularFunction {
    private final TreeMap<Double, Double> points = new TreeMap<>();

    public void addPoint(double x, double y) {
        points.put(x, y);
    }

    @Override
    public double calculate(double x) {
        Map.Entry<Double, Double> floor = points.floorEntry(x);
        Map.Entry<Double, Double> ceil = points.ceilingEntry(x);
        if (floor != null && ceil != null && !floor.getKey().equals(ceil.getKey())) {
            return interpolate(x, floor.getKey(), floor.getValue(), ceil.getKey(), ceil.getValue());
        }
        return floor != null ? floor.getValue() : 0.0;
    }
}