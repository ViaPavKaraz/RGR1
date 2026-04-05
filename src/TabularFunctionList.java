import java.util.*;

public class TabularFunctionList extends TabulatedFunction {
    private List<FileHandler.Point> points = new ArrayList<>();

    public void addPoint(double x, double y) {
        points.add(new FileHandler.Point(x, y));
        points.sort(Comparator.comparingDouble(p -> p.x));
    }

    @Override
    public double calculate(double x) {
        if (points.isEmpty()) return 0;
        if (x <= points.get(0).x) return points.get(0).y;
        if (x >= points.get(points.size() - 1).x) return points.get(points.size() - 1).y;
        for (int i = 0; i < points.size() - 1; i++) {
            if (x >= points.get(i).x && x <= points.get(i + 1).x) {
                return interpolate(x, points.get(i).x, points.get(i).y, points.get(i+1).x, points.get(i+1).y);
            }
        }
        return 0;
    }
}