import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;
import javax.swing.*;
import java.awt.*;

public class FunctionGrapher extends JFrame {
    private JTextField formulaInput = new JTextField("exp(-a*x^2)*sin(x)", 20);
    private JTextField aInput = new JTextField("1.0", 5);
    private JPanel chartPanelArea = new JPanel(new BorderLayout());

    public FunctionGrapher() {
        super("РГР №1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel tools = new JPanel();
        JButton btn = new JButton("Draw");
        tools.add(new JLabel("f(x)=")); tools.add(formulaInput);
        tools.add(new JLabel("a=")); tools.add(aInput);
        tools.add(btn);

        add(tools, BorderLayout.NORTH);
        add(chartPanelArea, BorderLayout.CENTER);

        btn.addActionListener(e -> {
            XYSeries s1 = new XYSeries("f(x)");
            XYSeries s2 = new XYSeries("f'(x) Num");
            XYSeries s3 = new XYSeries("f'(x) Sym");

            ParserFunction pf = new ParserFunction(formulaInput.getText(), Double.parseDouble(aInput.getText()));
            NumericalDifferentiator nd = new NumericalDifferentiator();

            for (double x = 1.5; x <= 6.5; x += 0.05) {
                s1.add(x, pf.calculate(x));
                s2.add(x, nd.derive(pf, x, 0.001));
                s3.add(x, pf.calculateSymbolicDerivative(x));
                FileHandler.saveResults("log.txt", x, pf.calculate(x), nd.derive(pf, x, 0.001));
            }

            XYSeriesCollection dataset = new XYSeriesCollection();
            dataset.addSeries(s1); dataset.addSeries(s2); dataset.addSeries(s3);
            JFreeChart chart = ChartFactory.createXYLineChart("Graph", "x", "y", dataset, PlotOrientation.VERTICAL, true, true, false);

            chartPanelArea.removeAll();
            chartPanelArea.add(new ChartPanel(chart));
            chartPanelArea.revalidate();
        });
        setSize(800, 600);
    }
}