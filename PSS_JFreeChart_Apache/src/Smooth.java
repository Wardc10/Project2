import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;

public class Smooth {

    //Apply a moving mean to smooth a list of values using Apache DescriptiveStatistics
    public void applyMovingMean(ArrayList<Double> values, int window) {
        // reate a temporary list to store the smoothed values
        ArrayList<Double> smoothedValues = new ArrayList<>();

        //Use DescriptiveStatistics to calculate the moving average
        DescriptiveStatistics stats = new DescriptiveStatistics();

        //Set the window size for the moving average
        stats.setWindowSize(window);

        //Iterate through the values and compute the moving mean
        for (double value : values) {
            stats.addValue(value);
            smoothedValues.add(stats.getMean());
        }

        //Update the original list with the smoothed values
        values.clear();
        values.addAll(smoothedValues);
    }
}
