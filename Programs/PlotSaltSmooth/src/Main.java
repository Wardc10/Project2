package src;
public class Main {
    public static void main(String[] args) throws Exception {
        //set the function you want to test
        String functionExpression = "-(x/5)^2 + 10*x";
        //create a new tester for the program
        Test_PSS tester = new Test_PSS();
        //testPSS also takes an integer input for the smoothing window.
        //add debug to toggle between hardcoded myFunc() and String functionExpression input: false = string input, true = hardcoded function
        tester.testPSS(functionExpression, 0, 100, 10, 2, false);
    }
}