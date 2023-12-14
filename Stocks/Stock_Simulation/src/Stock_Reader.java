import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Stock_Reader {
    public static ArrayList<Stock> stockData = new ArrayList<Stock>();

    public static void read_csv(String csvFile) {

        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null) {
                String[] count = line.split(",");
                Stock day = new Stock(count[0], (count[1]), (count[4]));
                stockData.add(day);
            }
            br.close();
            stockData.remove(0);

        } catch(IOException e){
            e.printStackTrace();
        }

    }

    

}

