public class Main {
    public static void main(String[] args){

        //initialie TestStatsLibrary object
        TestStatsLibrary tester = new TestStatsLibrary();
        //populate the test array from '1.0' to 'd.d'. This is used for several tests. I used '10.0' for d for this example
        tester.populateTestArray(10.0);
        //run the tests with the now populated array
        tester.testStatsFunctions();
        //tester for Permutation and Combination
        
        tester.testPermutationCombination(6,3);
        //tester for the distribution functions
        tester.testDistributions(5, 0.4, 0.6, 2);
        //print the results of our stats tests
    }
}