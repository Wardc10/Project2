import java.util.ArrayList;
import java.util.Collections;

public class StatCalculations {
     StatsLibrary sl = new StatsLibrary();

    StatCalculations(){
        
    }
    //chapter 1, mean, median, mode

    //method to return the avg points scored by all players in the NHL
    public double avgPoints(){
        ArrayList<Double> points = new ArrayList<Double>();
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            //add all players point totals to a 'points' array for calculation
            points.add(Double.valueOf(Read_CSV.playerData.get(i).getPoints()));
        }
        //utilizes my statslibrary for the mean calculation
        return sl.findMean(points);
    }

    //method to return the avg goals scored by all players in the NHL
    public double avgGoals(){
        ArrayList<Double> goals = new ArrayList<Double>();
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            //add all players goal totals to a 'goals' array for calculation
            goals.add(Double.valueOf(Read_CSV.playerData.get(i).getGoals()));
        }
        //utilizes my statslibrary for the mean calculation
        return sl.findMean(goals);
    }

    //method that returns the median number of points scored by all players in the NHL.
    public double medianPoints(){
        ArrayList<Double> points = new ArrayList<Double>();
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            //add all players point totals to 'points' array for calculation
            points.add(Double.valueOf(Read_CSV.playerData.get(i).getPoints()));
        }
        //again statslibrary for median calculation
        return sl.findMedian(points);
    }
    //method to return mode, repeating same process as mean/median
    public double modePoints(){
        ArrayList<Double> points = new ArrayList<Double>();
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            points.add(Double.valueOf(Read_CSV.playerData.get(i).getPoints()));
        }
        return sl.findMode(points);
    }
  
    //method to return the avg points scored, but only the 100 players with the most points.
    public double avgPoints_Top100(){
        ArrayList<Double> points = new ArrayList<Double>();
        ArrayList<Double> top100points = new ArrayList<Double>();
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            points.add(Double.valueOf(Read_CSV.playerData.get(i).getPoints()));
        }
        Collections.sort(points, Collections.reverseOrder());
        for(int i=0; i<100; i++) {
            top100points.add(Double.valueOf(Read_CSV.playerData.get(i).getPoints()));
        }
        return sl.findMean(top100points);
    }
    
    //method to return the total number of skaters in the dataset
    public int numSkaters(){
        int skaters = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            skaters++;
        }
        return skaters;
    }

    //method to return the total number of defensemen in the dataset
    public int numDefensemen(){
        int defensemen = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            if(Read_CSV.playerData.get(i).getPosition().equals("D")){
                defensemen++;
            }
           
        }
        return defensemen;
    }

    //method to return total number of forwards in the dataset
    public int numForwards(){
        int forwards = 0;
        int skaters = 0;
        int defensemen = 0;
        skaters = numSkaters();
        defensemen = numDefensemen();
        forwards = skaters-defensemen;
        return forwards;
    }

    //method to return the number of players who had over 100 points
    public int over100points(){
        int over100 = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            if(Read_CSV.playerData.get(i).getPoints() >= 100){
                over100++;
            }
        }
        return over100;
    }
    //method to return number of players who had over 90 points
    public int over90points(){
        int over90 = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            if(Read_CSV.playerData.get(i).getPoints() >= 100){
                over90++;
            }
        }
        return over90;
    }

    //method to return avg points but only within players who player 41 or more games (half the regular season)
    public int avgPoints_41GP(){
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

    public int leagueTotalGoals(){
        int total_goals = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            total_goals+=(Read_CSV.playerData.get(i).getGoals());
        }
        return total_goals;
    }

    public int leagueTotalShots(){
        int total_shots = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            total_shots+=(Read_CSV.playerData.get(i).getSOG());
        }
        return total_shots;
    }
    //method to return the leaguewide shooting percentage
    public double leagueShotPercentage(){
        double shootingPercentage = Double.valueOf(leagueTotalGoals())/Double.valueOf(leagueTotalShots());
        return shootingPercentage;
    }

    public int has_a_point = 0;
    public int has_no_points = 0;
    //calculates the percentage of players that don't have a point on the season
    //based off of example 3.7 
    public double percent_defective(){
        
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            if(Read_CSV.playerData.get(i).getPoints() >= 1){
                has_a_point++;
            }
            else{
                has_no_points++;
            }
        }
        String point = String.valueOf(has_a_point);
        String no_points = String.valueOf(has_no_points);
        double point_ratio = Double.valueOf(no_points)/Double.valueOf(point);
        return point_ratio;

    }

    //method to return total amount of goals a specific team scored 
    public int totalTeamGoals(String team){
        int teamGoals = 0;
        //loop through player data, searching for team ID match (NJD == NJD) and adds matching players goals to team total.
        //*Note: player team's listed are after the trade deadline, 
        //so players may have scored for a different team then been traded causing our team totals to be inaccurte
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            String currentTeam = Read_CSV.playerData.get(i).getTeam();
            //team tag comparison
            if(team.equals(currentTeam)){
                //get current players goals
                int goals = Read_CSV.playerData.get(i).getGoals();
                //add to team goal total
                teamGoals += goals;
            }
        }
        return teamGoals;
    }

    //method to return the average number of shots by all players in the NHL.
    public double avgShotsNHL(){
        //use our numSkaters and leagueTotalShots methods to easily calculate this.
        int totalSkaters = numSkaters();
        int totalShots = leagueTotalShots();
            //calculate avg shots per skater
            int avgSOG = totalShots/totalSkaters;
            return avgSOG;
        } 
    
    //
    public double ShotsStandardDeviation(){
        ArrayList<Double> SD = new ArrayList<Double>();
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            SD.add(Double.valueOf(Read_CSV.playerData.get(i).getSOG()));
        }
        return sl.findSD(SD);
    }

    public double GoalsStandardDeviation(){
        ArrayList<Double> SD = new ArrayList<Double>();
        for(int i=0; i<Read_CSV.playerData.size(); i++) {
            SD.add(Double.valueOf(Read_CSV.playerData.get(i).getGoals()));
        }
        return sl.findSD(SD);
    }

    public int over50Goals(){
        int over50 = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            if(Read_CSV.playerData.get(i).getGoals() >= 50){
                over50++;
            }
        }
        return over50;
    }

    public int playersOver80Hits(){
        int over80 = 0;
        for(int i=0; i<Read_CSV.playerData.size(); i++){
            if(Read_CSV.playerData.get(i).getHits() >= 80){
                over80++;
            }
        }
        return over80;
    }
}
