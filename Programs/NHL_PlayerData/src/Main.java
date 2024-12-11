import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Make sure nhl-stats.csv is in the filepath.
        String csvFile = "resources/nhl-stats.csv";
        // Read csv file with nhl player stats from the 2023-24season.
        Read_CSV.read(csvFile);
        Test_Player_Data tester = new Test_Player_Data();
        tester.printResults();
    }
}
