public class Test_PSS {
    public static void main(String[] args) throws Exception {
        //Creates "Unsalted_Function.csv" based on function chosen in Plotter Class
        Plotter plot = new Plotter();
        plot.plot();
        //Takes CSV File created from Plotter and Salts the values, returning "Salted_Function.csv"
        Salter salt = new Salter();
        salt.salt("Unsalted_Function.csv");
        //Takes CSV File created from Salter and Smooths the values, returning "Smoothed_Function.csv"
        Smoother smooth = new Smoother();
        smooth.smooth("Salted_Function.csv",2);
    }
}
