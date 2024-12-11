import java.text.DecimalFormat;

public class Test_Player_Data {

    private  final DecimalFormat df = new DecimalFormat("0.00");

    StatsLibrary sl = new StatsLibrary();
    StatCalculations sc = new StatCalculations();
    public void printResults(){
        //chapter 1, mean median mode # of points in the NHL
        System.out.println("Average Number of Points Scored in the 2023-24 NHL Season, among all Skaters: "+df.format(sc.avgPoints()));
        System.out.println("Median Number of Points Scored in the 2023-24 NHL Season, among all Skaters: "+df.format(sc.medianPoints()));
        System.out.println("The Mode of Points Scored in the 2023-24 NHL Season, among all skaters: "+df.format(sc.modePoints()));

        //print avg points, within top 100 point scorers, and within player who have 41+games
        System.out.println("Average number of points scored in the 2023-24 NHL Season, within the top 100 point-scorers: "+df.format(sc.avgPoints_Top100()));
        System.out.println("Average number of points scored in the 2023-24 NHL Season, with 41+ games played: "+df.format(sc.avgPoints_41GP()));

        //players 
        System.out.println("Number of Players who scored over 100 points, in the 2023-24 NHL Season: "+sc.over100points());
        System.out.println("Number of Defensemen that played a game in the 2023-24 NHL Season: "+sc.numDefensemen());
        System.out.println("Number of Forwards that played a game in the 2023-24 NHL Season: "+sc.numForwards());
        System.out.println("Number of Total Skaters that played a game in the 2023-24 NHL Season: "+sc.numSkaters());
        System.out.println("Number of Forwards in ");

        sc.leagueShotPercentage();
        System.out.println("Number of ways 32 teams can make it to a 16 team playoff matchup: "+sl.findCombination(32, 16));
        System.out.println("Ratio of players with no points to players with at least a point: "+sc.percent_defective());
        System.out.println("Probability that you will find a player without a point, if 5 that are randomly picked: "+(1 - sl.binomial(5, 0, .118, .882)));
        System.out.println("Probability that the third shot on goal is the first to go in: "+sl.geometric(.1, .9, 3));
        System.out.println("Probability that the no shots on goal go in out of 20 in a period: "+sl.geometric(.1, .9, 0));
        System.out.println("Probability that the first player with a point is found on 2nd trial: "+sl.negative_binomial(2,1,.118,.882));
        System.out.println("Probability that the first player with a point is found on or before the 3rd trial: "+(sl.negative_binomial(3,1,.118,.882)+sl.negative_binomial(2,1,.118,.882)+sl.negative_binomial(1,1,.118,.882)));

        //"BOS","NYR","FLA","TOR","NYI","DET","PHI","WSH","NJD","CAR","TBL","PIT","MTL","BUF","CBJ","OTT",
        //"ANA","ARI","CGY","CHI","COL","DAL","EDM","LAK","MIN","NSH","SEA","SJS","STL","VAN","VGK","WPG"
        String team = "NJD";
        System.out.println("Number of goals scored by "+team+" in the 2023-24 NHL season.: "+sc.totalTeamGoals(team));

        System.out.println("Total Goals Scored in the 2023-24 NHL Season: "+sc.leagueTotalGoals());
        System.out.println("Total Shots on Goal in the 2023-24 NHL Season: "+sc.leagueTotalShots());
        System.out.println("Shooting Percentage Among All Skaters in the 2023-24 NHL Season: "+sc.leagueShotPercentage());
        
        System.out.println("Average Number of Shots per Player in the 2023-24 NHL Season: "+sc.avgShotsNHL());
        System.out.println("Standard Deviation for Average Number of Shots on Goal in the 2023-24 NHL Season, among all Skaters: "+sc.ShotsStandardDeviation());

        System.out.println("Average Number of Goals per Player in the 2023-24 NHL Season: "+sc.avgGoals());
        System.out.println("Standard Deviation for Average Number of Goals in the 2023-24 NHL Season, among all Skaters: "+sc.GoalsStandardDeviation());

        System.out.println("Number of Players who scored over 50 goals, in the 2023-24 NHL Season: "+sc.over50Goals());
        System.out.println("Number of Players who had over 80 hits, in the 2023-24 NHL Season: "+sc.playersOver80Hits());
        //System.out.println("Probability that all 5 top point scorers are in the All Star Game (if random selection): "+sl.hypergeometric(5,5,924,20));
        // for(int i=0; i<50; i++){
        //     Player data = Read_CSV.playerData.get(i);
        //     System.out.println(data.getName()+" "+data.getTeam()+" "+data.getPosition()+" "+data.getGamesPlayed()+" "+data.getGoals()
        //         +" "+data.getAssists()+" "+data.getPoints()+" "+data.getPlusMinus()+" "+data.getPIM()+" "+data.getSOG()+" "+data.getGWG()
        //          +" "+data.getPPG()+" "+data.getPPA()+" "+data.getSHG()+" "+data.getSHA()+" "+data.getHits());
        // }

    }

}