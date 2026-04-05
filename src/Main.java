public class Main {
    public static void main(String[] args) {
        MathFunction f1 = new FunctionWithoutParams();
        MathFunction f2 = new FunctionWithParams(0.5);
        Differentiator diff = new NumericalDifferentiator();

        double precision = 0.001; // Задана точність

        System.out.println("Тестування функції f(x) = exp(-x^2) * sin(x)");
        // Цикл від 1.5 до 6.5 з кроком 0.05
        for (double x = 1.5; x <= 6.5; x += 0.05) {
            double y = f1.calculate(x);
            double derivative = diff.derive(f1, x, precision);

            // Збереження у файл
            FileHandler.saveResults("results.txt", x, y, derivative);
            System.out.printf("x = %.2f | f(x) = %.4f | f'(x) = %.4f\n", x, y, derivative);
        }
    }
}