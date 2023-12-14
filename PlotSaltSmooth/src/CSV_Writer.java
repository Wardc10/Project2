import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV_Writer {
    private static final String header = "x values,y values";

    public static void writeCsvFile(String fileName, ArrayList<Coord> c) { 

        try { 
            FileWriter fileWriter = new FileWriter(fileName); 
 
            //Write the CSV file header 
            fileWriter.append(header); 
            fileWriter.append("\n"); 
 
            //Write data to the CSV file 
            for(int i=0; i<c.size(); i++) { 
                fileWriter.append(String.valueOf(c.get(i).getX())); 
                fileWriter.append(","); 
                fileWriter.append(String.valueOf(c.get(i).getY())); 
                fileWriter.append("\n");
            } 
            
            //Flush and close the filewriter
            fileWriter.flush(); 
            fileWriter.close();

        } catch (IOException e) { 
            System.out.println("Error Creating csv File."); 
            e.printStackTrace(); 
        } 
    } 
    
}
