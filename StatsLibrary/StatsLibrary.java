import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
public class StatsLibrary
{
	//mean method
	public double findMean(ArrayList<Double> userInputNumbers) {
		double sum = 0;
		for(double singleElement : userInputNumbers) {
			sum  = sum + singleElement;
		}
		
		//Storing value for clarity
		double result = sum / userInputNumbers.size();
		return result;
	}
	
	//median method
	public double findMedian(ArrayList<Double> userInputNumbers) {
		if(userInputNumbers.isEmpty()) {
			return 0.0;
		}
		userInputNumbers.sort(Comparator.naturalOrder());
		int n = userInputNumbers.size();
		if (n % 2 == 0) {
			return ((userInputNumbers.get((n-1)/2) + userInputNumbers.get(n/2)) / 2);
		}
		else {
			return userInputNumbers.get(n/2);
		}
	}
	
	//mode method
	public double findMode(ArrayList<Double> userInputNumbers) {

		if(userInputNumbers.isEmpty()){

		}
		int maxCount = 0;
		double maxValue = 0;
		int n = userInputNumbers.size();
		for(int i=0; i<n; i++) {
			int count = 0;
			for(int j=0; j<n; j++) {
				if(userInputNumbers.get(j).equals(userInputNumbers.get(i))) {
					count++;
				}
			}
			if(count > maxCount) {
				maxCount = count;
				maxValue = userInputNumbers.get(i);
			}
		}
		//this return NaN if there is no mode
		//used NaN so i could return type double without printing anything to cmd like ("No mode found")
		if(maxCount == 1){
			return Double.NaN;
		}
		return maxValue;
	}
	
	//Variance method
	public double findVariance(ArrayList<Double> userInputNumbers) {
		double mean = findMean(userInputNumbers);
		int n = userInputNumbers.size();
		double squaredDifference = 0;
		for(int i=0; i<n; i++) {
			squaredDifference += (userInputNumbers.get(i)-mean) * (userInputNumbers.get(i)-mean);
		}
		return squaredDifference/n;
	}
	
	//Standard Deviation method
	public double findSD(ArrayList<Double> userInputNumbers) {
		double sd = 0;
		int n = userInputNumbers.size();
		
		for(int i = 0; i<n; i++) {
			sd += Math.pow(userInputNumbers.get(i)-findMean(userInputNumbers), 2);
		}
		return Math.sqrt(sd/n-1);
	}
	
    //Factorial method using BigInteger
    public BigInteger factorial (int n){
    	BigInteger result = BigInteger.valueOf(1);
        for(int i = n; i > 0; i--) {
        	result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    
    //secondary factorial function with long, had trouble with BigInt factorial in binomial distribution solver
    public static long fact(int n) {
        long result = 1;
        for(int i = n; i > 0; i--) {
        	result *= i;
        }
        return result;
    }
	
	//Permutations Method
	public BigInteger findPermutation(int n, int r) {
		if(n < 0 || r < 0 || r > n) {
			return null;
		}
		else {
			return factorial(n).divide(factorial(n -r));
		}
	}
	
	//Combinations Method -- had to make type biginteger to use my own factorial method
	public BigInteger findCombination(int n, int r) {
        if(n < 0 || r < 0 || r > n) {
            return null;
        }
        else {
        	return factorial(n).divide((factorial(r).multiply(factorial(n - r))));
        }
    }
	
	//Probability Axioms
	//True if axiom holds and false if it does not
	
	//Axiom 1: P(A) >= 0
	public boolean axiom_1 (double a) {
		if (a <= 0) {
			return false;
		}
		return true;
	}
	
	//Axiom 2: P(S) = 1
	public boolean axiom_2 (ArrayList<Double> probabilities) {
		int p = probabilities.size();
		int S = 0;
		for(int i=0; i<p; i++) {
			S += probabilities.get(i);
		}
		if(S > 1 || S < 1) {
			return false;
		}
		return true;
	}
	
	//Axiom 3: 
	public boolean axiom_3 (ArrayList<Double> probabilities) {
		int p = probabilities.size();
		int S = 0;
		for(int i=0; i<p; i++) {
			S +=  probabilities.get(i);
		}
		if(S > 1) {
			return false;
		}
		return true;
	}
	
	public double combination (int n, int r) {
		return fact(n)/(fact(r)*fact(n-r));
	}
	
	//Binomial Distribution Solver
	public double binomial (int n, int y, double p, double q) {
		return combination(n,y)*Math.pow(p, y)*Math.pow(q, n-y);
	}
	
	//Geometric Distribution Solver
	public double geometric (double p, double q, double y) {
        return (Math.pow(q, y-1)) * p;
    }

	//Hypergeometric Distribution solver 
	public double hypergeometric (int r, int y, int bign, int n) {
		return (combination(r,y)*combination(bign-r,n-y))/combination(bign,n);
	}
	
	//Negative Binomial Distribution Solver
	public double negative_binomial (int y, int r, double p, double q) {
		return combination(y-1,r-1)*(Math.pow(p, r))*Math.pow(q, y-r);
	}
	
	//Poisson Distribution
	public double poisson (double lambda, int y) {
		return (Math.pow(lambda, y)/fact(y))*Math.pow(2.71828, -lambda);
	}

	//method to calculate the tchebysheff probability, output of 0.0 means Tchebysheff doesn't work.
	public double tchebysheff(double mean, double sigma, double lower, double upper){
		double tchebysheff = 0.0;
		double withinU = upper-mean;
		double withinL = mean-lower;
		//doesn't matter which one we use since they should be the same
		double k = withinL*withinL;
		if(withinL == withinU){
			tchebysheff = 1-1/k;
			return tchebysheff;
		}
		return tchebysheff;
	}

}