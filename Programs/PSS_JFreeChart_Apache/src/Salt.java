import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.JDKRandomGenerator;

import java.util.ArrayList;

public class Salt {

    //Add Gaussian random numbers to a list of values
    public void addSalt(ArrayList<Double> values) {
        GaussianRandomGenerator randomGenerator = new GaussianRandomGenerator(new JDKRandomGenerator());

        for (int i = 0; i < values.size(); i++) {
            double saltValue = values.get(i) + randomGenerator.nextNormalizedDouble() * 5;
            values.set(i, saltValue);
        }
    }
}
    