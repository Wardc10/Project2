package src;
import java.util.ArrayList;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Plotter {
    // ArrayList to hold the coordinates of a function
    ArrayList<Pair> coordinates = new ArrayList<Pair>();

    //The Function I'm testing is y = -(x/5)^2 + 5x
    public double myFunc(int x){
        return (((Math.pow(x, 2)/5)*-1)+(5*x));
   }

    // Method to evaluate a given expression string for a specific value of x
    // The exp4j Expression Builder library is used to evalute the string expression input from the user
    public double evaluateFunction(String expressionString, double xValue) {
        // Create an expression using exp4j, as shown on the objecthunter exp4j documentation
        Expression expression = new ExpressionBuilder(expressionString)
                .variable("x")
                .build()
                .setVariable("x", xValue);

        // Evaluate the expression
        return expression.evaluate();
    }

    // Takes in x range, evaluates the function, and adds coordinates to an ArrayList<Coord>
    public ArrayList<Pair> findCoords(String expression, int start, int end) {
        String x, y;

        for (int i = start; i <= end; i++) {
            // Set x and evaluate y using the expression
            x = String.valueOf(i);
            y = String.valueOf(evaluateFunction(expression, i));
            
            // Create coordinates and add to the ArrayList
            Pair coords = new Pair(x, y);
            coordinates.add(coords);
        }
        return coordinates; 
    }

    public ArrayList<Pair> findCoordsDEBUG(int start, int end){
        String x,y;

        for(int i = start; i <= end; i++){
            //set x and y values
            x = String.valueOf(i);
            y = String.valueOf(myFunc(i));
            //create coords and add to an ArrayList<Coords>
            Pair coords = new Pair(x, y);
            coordinates.add(coords);
        }
        return coordinates; 
    }

    public void plot(String function, int start, int end, boolean debugValue) {
        
        // Create a Plotter object and plot points from x range: 0-50
        final Plotter p = new Plotter();
        if(debugValue == true){
            // Find coordinates for the specified range
            p.findCoords(function, start, end);
        }
        else{
            p.findCoordsDEBUG(start, end);
        }
        // Writes coordinates of the function to a CSV file
        CSV_Writer.writeCsvFile("Unsalted_Function.csv", p.coordinates);
    }
}
