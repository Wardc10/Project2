import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //define the function expression
        String functionExpression = "-x^2 + 3*x";

        //define the range and step size
        double start = -10;
        double end = 10;
        double step = 0.1;

        //initialize calculations and plot
        Calculations calculations = new Calculations();
        Plot plot = new Plot();

        //generate values
        ArrayList<Double> xValues = calculations.generateXValues(start, end, step);
        ArrayList<Double> yValues = calculations.generateYValues(functionExpression, xValues);
        ArrayList<Double> saltedYValues = calculations.applySalt(yValues);
        ArrayList<Double> smoothedYValues = calculations.applySmoothing(saltedYValues);

        //plot the graph
        plot.displayGraph(functionExpression, start, end, step);
    }
}
