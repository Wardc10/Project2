import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read_CSV {
    public static ArrayList<Player> playerData = new ArrayList<Player>();

    public static void read(String csvFile) throws IOException {
        
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while((line = br.readLine()) != null) {
                String[] count = line.split(",");
                //Create Player objects and add them to playerData array
                Player p = new Player(count[0], count[1], count[2], count[3], count[4], count[5],
                 count[6], count[7], count[8], count[9], count[10], count[11],
                  count[12], count[13], count[14], count[15]);
                playerData.add(p);
            }
            br.close();
            //Remove first entry to get rid of titles from csv, (useful to avoid type conversion error from String to int)
            playerData.remove(0);
            //playerData.remove(0);

        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
