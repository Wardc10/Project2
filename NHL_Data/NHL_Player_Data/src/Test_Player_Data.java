import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Test_Player_Data {

    static StatsLibrary sl = new StatsLibrary();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static double avgPoints(){
        ArrayList<Double> points = new ArrayList<Double>();
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            points.add(Double.valueOf(Read_CSV.playerData.get(i).getPoints()));
        }
        return sl.findMean(points);
    }

    public static double avgPoints_Top100(){
        ArrayList<Double> top100points = new ArrayList<Double>();
        for(int i=0; i<99; i++) {
            top100points.add(Double.valueOf(Read_CSV.playerData.get(i).getPoints()));
        }
        return sl.findMean(top100points);
    }
    public static int numdefensemen(){
        int defensemen = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            if(Read_CSV.playerData.get(i).getPosition().equals("D")){
                defensemen++;
            }
           
        }
        return defensemen;
    }
    public static int over100points(){
        int over = 0;
        for(int i=0; i<99; i++){
            if(Read_CSV.playerData.get(i).getPoints() >= 100){
                over++;
            }
        }
        return over;
    }
    public static int dmanover100(){
        int d_over = 0;
        for(int i=0; i<99; i++){
            if((Read_CSV.playerData.get(i).getPoints() >= 100) && Read_CSV.playerData.get(i).getPosition().equals("D")){
                d_over++;
            }
        }
        return d_over;
    }

    public static int avgPoints_41GP(){
        ArrayList<Player> over41GP = new ArrayList<Player>();
        int avg_points = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            if(Read_CSV.playerData.get(i).getGamesPlayed() >= 41){
                over41GP.add(Read_CSV.playerData.get(i));
                avg_points += Read_CSV.playerData.get(i).getPoints();
            }
        }
        return avg_points/over41GP.size();
    }

    public static int total_goals = 0;
    public static int total_shots = 0;    
    public static void leagueshotpercentage(){
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            total_goals+=(Read_CSV.playerData.get(i).getGoals());
            total_shots+=(Read_CSV.playerData.get(i).getSOG());
        }
        String goal = String.valueOf(total_goals);
        String shot = String.valueOf(total_shots);
        System.out.println("Total Goals Scored in the 2022-23 NHL Season: "+total_goals);
        System.out.println("Total Shots on Goal in the 2022-23 NHL Season: "+total_shots);
        double shooting_percentage = Double.valueOf(goal)/Double.valueOf(shot);
        System.out.println("Shooting Percentage Among All Skaters in the 2022-23 NHL Season: "+shooting_percentage);
    }

    // logic is flawed, doesn't work as I thought it would.
    // public static double secondary_assists_on_a_goal() {
    //     double total_goals = 0;
    //     double total_assists = 0;

    //     for(int i=0; i<CSV_Reader.playerData.size(); i++){
    //         total_goals += CSV_Reader.playerData.get(i).getGoals();
    //         total_assists += CSV_Reader.playerData.get(i).getAssists();
    //     }
    //     return (total_assists-total_goals)/total_goals;
    // }


    public static void printResults(){
        System.out.println("Average Number of Points Scored in the NHL 2022/23 Season, among all Skaters: "+df.format(avgPoints()));
        System.out.println("Average Number of Points Scored in the NHL 2022/23 Season, Within the top 100 Point-scorers: "+df.format(avgPoints_Top100()));
        System.out.println("Average Number of Points Scored in the NHL 2022/23 Season, With 41+ Games Played: "+df.format(avgPoints_41GP()));
        System.out.println("Number of Players in the NHL 2022/23 Season, With Over 100 Points: "+over100points());
        System.out.println("Number of Defensemen that played a game in the NHL 2022/23 Season: "+numdefensemen());
        System.out.println("Number of Defensemen in the NHL 2022/23 Season, With Over 100 Points: "+dmanover100());
        leagueshotpercentage();
        System.out.println("Number of ways 16 teams can randomly be assigned to 8 playoff mathcups: "+sl.combination(16, 8));

        // for(int i=0; i<50; i++){
        //     Player data = CSV_Reader.playerData.get(i);
        //     System.out.println(data.getName()+" "+data.getTeam()+" "+data.getPosition()+" "+data.getGamesPlayed()+" "+data.getGoals()
        //         +" "+data.getAssists()+" "+data.getPoints()+" "+data.getPlusMinus()+" "+data.getPIM()+" "+data.getSOG()+" "+data.getGWG()
        //          +" "+data.getPPG()+" "+data.getPPA()+" "+data.getSHG()+" "+data.getSHA()+" "+data.getHits());
        // }

    }

    public static void main(String[] args) throws IOException {
        // Read csv file with nhl player stats from the 2022-23 season.
        // Change filepath for your own system.
        String csvFile = "C:/Users/wardc/Documents/nhl-stats.csv";
        Read_CSV.read(csvFile);
        printResults();
    }
}