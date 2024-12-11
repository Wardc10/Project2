package src;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSV_Writer {
    private static final String header = "x values,y values";

    public static void writeCsvFile(String fileName, ArrayList<Pair> c) {
        //Specify the desired path (I want the CSVs to go in their own resources folder after creation)
        String directory = "PlotSaltSmooth/resources/";
        
        try {
            //Ensure the directory exists
            Files.createDirectories(Paths.get(directory));

            //Combine the directory and file name
            String filePath = directory + fileName;

            FileWriter fileWriter = new FileWriter(filePath);

            //Write the CSV file header
            fileWriter.append(header);
            fileWriter.append("\n");

            //Write data to the CSV file
            for (int i = 0; i < c.size(); i++) {
                fileWriter.append(String.valueOf(c.get(i).getX()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(c.get(i).getY()));
                fileWriter.append("\n");
            }

            //Flush and close the file writer
            fileWriter.flush();
            fileWriter.close();

            System.out.println("CSV file created successfully at: " + filePath);

        } catch (IOException e) {
            System.out.println("Error creating CSV file.");
            e.printStackTrace();
        }
    }
}
