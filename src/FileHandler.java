import java.io.*;
import java.util.TreeMap;
import java.util.TreeSet;

public class FileHandler {
    public static void saveResults(String filename, double x, double y, double derivative) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(String.format("x=%.2f; f(x)=%.4f; f'(x)=%.4f%n", x, y, derivative));
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static class Point implements Comparable<Point> {
        public double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
        @Override
        public int compareTo(Point o) { return Double.compare(this.x, o.x); }
    }
}