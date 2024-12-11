import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.ArrayList;

public class Calculations {

    //generate x and y values for the given function
    public ArrayList<Double> generateXValues(double start, double end, double step) {
        ArrayList<Double> xValues = new ArrayList<>();
        for (double x = start; x <= end; x += step) {
            xValues.add(x);
        }
        return xValues;
    }

    public ArrayList<Double> generateYValues(String functionExpression, ArrayList<Double> xValues) {
        ArrayList<Double> yValues = new ArrayList<>();
        Expression expression = new ExpressionBuilder(functionExpression).variable("x").build();
        for (double x : xValues) {
            expression.setVariable("x", x);
            yValues.add(expression.evaluate());
        }
        return yValues;
    }

    //apply salt to the y-values
    public ArrayList<Double> applySalt(ArrayList<Double> yValues) {
        ArrayList<Double> saltedYValues = new ArrayList<>(yValues);
        Salt salt = new Salt();
        salt.addSalt(saltedYValues);
        return saltedYValues;
    }

    //apply smoothing to the salted y-values
    public ArrayList<Double> applySmoothing(ArrayList<Double> saltedYValues) {
        ArrayList<Double> smoothedYValues = new ArrayList<>(saltedYValues);
        Smooth smooth = new Smooth();
        smooth.applyMovingMean(smoothedYValues, 5);
        return smoothedYValues;
    }
}

