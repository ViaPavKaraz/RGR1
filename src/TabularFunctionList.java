import java.util.*;
public class TabularFunctionList extends AbstractTabularFunction {
    private final List<Point> points = new ArrayList<>();

    public void addPoint(double x, double y) {
        points.add(new Point(x, y));
        points.sort(Comparator.comparingDouble(p -> p.x));
    }

    @Override
    public double calculate(double x) {
        return Math.sin(x); // Заглушка
    }

    private static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }
}