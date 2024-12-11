import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TestStatsLibrary {

	//initialize the StatsLibrary
	private StatsLibrary test = new StatsLibrary();

	//initilize our array of userInputNumbers
	ArrayList<Double> userInputNumbers = new ArrayList<>();
	//extra array to test mode, since userInputNumbers population is only increasing values - no duplicates
	ArrayList<Double> modeTestArray = new ArrayList<>(List.of(1.0,2.0,2.0,3.0,4.0,5.0,5.0,5.0,6.0,7.0,8.0,9.0,10.0,10.0));

	// Declare variables to hold test results
    private double meanResults;
    private double medianResults;
    private double modeResults;
	private double modeResults2;
    private double varianceResults;
    private double sdResults;

    private BigInteger factorialResult;

    private BigInteger permutationResults;
    private BigInteger combinationResults;

    private double geometricResults;
    private double binomialResults;

	//this method will fill the userInputNumbers array with doubles from 1.0 to d
	public ArrayList<Double> populateTestArray(Double d){
		
		//fill array with values
		for(Double i=1.0; i<d; i++){
			userInputNumbers.add(i);
		}
		return userInputNumbers;
	}

	public void testStatsFunctions(){
		meanResults = test.findMean(userInputNumbers);
		medianResults = test.findMedian(userInputNumbers);
		modeResults = test.findMode(userInputNumbers);
		modeResults2 = test.findMode(modeTestArray);
		varianceResults = test.findVariance(userInputNumbers);
		sdResults = test.findSD(userInputNumbers);
		System.out.println("This is the mean of userInputNumbers: " + meanResults);
		System.out.println("This is the median of userInputNumbers: " + medianResults);
		//NaN result is because there is no mode in a function of increasing doubles such as, (1.0,2.0,3.0,...,10.0), as all #'s occur just once
		System.out.println("This is the mode of userInputNumbers: " + modeResults);
		//extra mode test since userInputNumbers is always NaN, this provides an accurate test of the mode method with 'modeTestArray' as the input
		System.out.println("This is the mode of modeTestArray: " + modeResults2);
		System.out.println("This is the variance of userInputNumbers: " + varianceResults);
		System.out.println("This is the Standard Deviation of userInputNumbers: " + sdResults);
		//adding spacer line to separate tests from userInputValues and test with independent inputs
		System.out.println();
	}
	public void testFactorial(int n){
		factorialResult = test.factorial(n);
		System.out.println("This is the BigInteger test of factorial: " + factorialResult);
		//spacer
		System.out.println();
	}

	public void testPermutationCombination(int n, int r){
		permutationResults = test.findPermutation(n, r);
		combinationResults = test.findCombination(n, r);
		System.out.println("This is the Permutation: " +  permutationResults);
		System.out.println("This is the Combination: " +  combinationResults);
		//spacer
		System.out.println();
	}

	public void testDistributions(int n, double p, double q, int y){
		geometricResults = test.geometric(p, p, y);
		binomialResults = test.binomial(n, y, p, q);
		System.out.println("This is the Geometric Distribution: " + geometricResults);
		System.out.println("This is the Binomial Distribution: " + binomialResults);
	}

}
