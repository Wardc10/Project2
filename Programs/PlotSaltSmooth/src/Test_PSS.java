package src;

public class Test_PSS {
    public void testPSS(String function, int start, int end, int saltBound, int window, boolean debugValue){
        //string function to be tested
        //Creates "Unsalted_Function.csv" based on function chosen in Plotter Class
        Plotter plot = new Plotter();
        plot.plot(function, 0, 100, debugValue);
        //Takes CSV File created from Plotter and Salts the values, returning "Salted_Function.csv"
        Salter salt = new Salter();
        salt.salt("PlotSaltSmooth/resources/Unsalted_Function.csv", saltBound);
        //Takes CSV File created from Salter and Smooths the values, returning "Smoothed_Function.csv"
        Smoother smooth = new Smoother();
        smooth.smooth("PlotSaltSmooth/resources/Salted_Function.csv", window);
    }
}
