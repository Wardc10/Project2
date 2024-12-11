import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.ArrayList;

public class Plot {

    //Display a graph of the given function with salted and smoothed data over the specified x-range
    public void displayGraph(String functionExpression, double start, double end, double step) {
        //XYSeries from JFreeChart to hold my function data
        XYSeries originalSeries = new XYSeries("Original Function");
        XYSeries saltedSeries = new XYSeries("Salted Function");
        XYSeries smoothedSeries = new XYSeries("Smoothed Function");

        //Build the expression from the string expression using exp4j
        Expression expression = new ExpressionBuilder(functionExpression).variable("x").build();

        //Generate x and y data points
        ArrayList<Double> xValues = new ArrayList<>();
        ArrayList<Double> yValues = new ArrayList<>();

        for (double x = start; x <= end; x += step) {
            expression.setVariable("x", x);
            double y = expression.evaluate();
            originalSeries.add(x, y);
            xValues.add(x);
            yValues.add(y);
        }

        //Generate salted x and y data points
        ArrayList<Double> saltedYValues = new ArrayList<>(yValues);
        Salt salt = new Salt();
        salt.addSalt(saltedYValues);
        for (int i = 0; i < xValues.size(); i++) {
            saltedSeries.add(xValues.get(i), saltedYValues.get(i));
        }

        //Generate smoothed x and y data points
        ArrayList<Double> smoothedYValues = new ArrayList<>(saltedYValues);
        Smooth smooth = new Smooth();
        smooth.applyMovingMean(smoothedYValues, 5);
        for (int i = 0; i < xValues.size(); i++) {
            smoothedSeries.add(xValues.get(i), smoothedYValues.get(i));
        }

        //Create XYSeriesColection and add our function
        //This will let us add more over time (salted/smoothed)
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(originalSeries);
        dataset.addSeries(saltedSeries);
        dataset.addSeries(smoothedSeries);

        //Create our chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Function Plot: " + functionExpression,
                "x",
                "y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        //Display chart in a JFrame
        JFrame frame = new JFrame("Function Plot: "+functionExpression);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}
