import java.util.TreeSet;

public class TabularFunctionSet extends TabulatedFunction {
    private TreeSet<FileHandler.Point> points = new TreeSet<>();

    public void addPoint(double x, double y) { points.add(new FileHandler.Point(x, y)); }

    @Override
    public double calculate(double x) {
        if (points.isEmpty()) return 0;
        FileHandler.Point low = null, high = null;
        for (FileHandler.Point p : points) {
            if (p.x <= x) low = p;
            if (p.x >= x) { high = p; break; }
        }
        if (low == null) return high.y;
        if (high == null) return low.y;
        return interpolate(x, low.x, low.y, high.x, high.y);
    }
}