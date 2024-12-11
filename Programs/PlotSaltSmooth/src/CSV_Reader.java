package src;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV_Reader {
    public static ArrayList<Pair> data = new ArrayList<Pair>();

    public static void read(String csvFile) throws IOException {
        
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null) {
                String[] count = line.split(",");
                //Create Player objects and add them to playerData array
                Pair e = new Pair(count[0], count[1]);
                data.add(e);
            }
            //close the buffer
            br.close();
            //Remove the header from csv,
            //This is so I don't get an error when converting from string to int 
            data.remove(0);

        } catch(IOException e){
            e.printStackTrace();
        }

    }

}
