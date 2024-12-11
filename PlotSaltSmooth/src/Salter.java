package src;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Salter {
    //arraylist for unsalted valued
    public ArrayList<Pair> unsalted = new ArrayList<Pair>();

    public void salt(String csvFile, int saltBound){
        Random rand = new Random();
        int r = 0;
        
        try {
            CSV_Reader.read(csvFile);
            //send csv data to unsalted arraylist
            for(int i=0; i<CSV_Reader.data.size(); i++){
                unsalted.add(CSV_Reader.data.get(i));
            }
            //clear csv_reader data array for next usage!
            CSV_Reader.data.clear();
           
        } catch(IOException e){
            System.out.println("Error Reading CSV File.");
            e.printStackTrace();
        }

        for(int i = 0; i<unsalted.size(); i++){
            //create random salt value from values 1-10
            //*+1 to handle if 0 is salt value*
            r = rand.nextInt(saltBound);

            //if r is even, positive salt
            if(r%2 == 0){
                //convert salt value to string for csv output
                String y = String.valueOf(unsalted.get(i).getY()+r);
                unsalted.get(i).setY(y);

            //if r is odd, negative salt
            } else {
                String y = String.valueOf(unsalted.get(i).getY()-r);
                unsalted.get(i).setY(y);
            }
        }
        CSV_Writer.writeCsvFile("Salted_Function.csv", unsalted);
    }
}
