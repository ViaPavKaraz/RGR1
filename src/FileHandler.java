import java.io.*;

public class FileHandler {
    // Збереження результатів у текстовий файл
    public static void saveResults(String filename, double x, double y, double derivative) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(String.format("x = %.2f | f(x) = %.4f | f'(x) = %.4f\n", x, y, derivative));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Читання CSV
    public static void loadCsvToMap(String filename, TabularFunctionMap map) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    map.addPoint(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }
}