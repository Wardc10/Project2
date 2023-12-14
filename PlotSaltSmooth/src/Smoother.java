import java.io.IOException;
import java.util.ArrayList;

public class Smoother {
    public ArrayList<Coord> unsmoothed = new ArrayList<>();
    public void smooth(String csvFile, int window) {
        double sum, rollingAvg;

        try {
            Read_CSV.read(csvFile);
            //send csv data to unsalted arraylist
            for(int i=0; i<CSV_Reader.data.size(); i++){
                unsmoothed.add(CSV_Reader.data.get(i));
            }
            //clear csv_reader data array for next usage!
            CSV_Reader.data.clear();
           
        } catch(IOException e){
            System.out.println("Error Reading CSV File.");
            e.printStackTrace();
        }

        for(int i=0; i<unsmoothed.size(); i++) {
            sum = 0;
            //set window bounds
            int lower = i-window;
            int upper = i+window;
            //if lower bound goes below zero, set to zero
            if(lower < 0){
                lower = 0;
            }
            //if upper bound goes beyond array size, set to array size
            if(upper > unsmoothed.size()){
                upper = unsmoothed.size();
            }
            //count to track array index 
            int count = 0;
            //add sum of coords in the window from lower bound to i
            while(lower < i){
                sum += unsmoothed.get(lower).getY();
                lower++;
                count++;
            }
            int j = i+1;
            //add sum of coords in window above i
            while(upper > j){
                sum += unsmoothed.get(j).getY();
                j++;
                count++;
            }
            //calculate the rolling average
            rollingAvg = sum / count;
            //change array value to new average value
            unsmoothed.get(i).setY(String.valueOf(rollingAvg));
        }
        CSV_Writer.writeCsvFile("Smoothed_Function.csv", unsmoothed);
    }
}
