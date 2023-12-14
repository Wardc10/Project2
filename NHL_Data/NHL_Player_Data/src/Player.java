import java.util.ArrayList;

public class Player {
    String name, team, position, gamesPlayed, goals,
     assists, points, plusMinus, penaltyMinutes,
      shotsOnGoal, gameWinningGoal, powerPlayGoal, powerPlayAssist,
       shortHandedGoal, shortHandedAssist, hits, east, west;
    Player(String name, String team, String position, String gamesPlayed, String goals, 
    String assists, String points, String plusMinus, String penaltyMinutes,
     String shotsOnGoal, String gameWinningGoal, String powerPlayGoal, String powerPlayAssist,
      String shortHandedGoal, String shortHandedAssist, String hits){
        this.name = name;
        this.team = team;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.points = points;
        this.plusMinus = plusMinus;
        this.penaltyMinutes = penaltyMinutes;
        this.shotsOnGoal = shotsOnGoal;
        this.gameWinningGoal = gameWinningGoal;
        this.powerPlayGoal = powerPlayGoal;
        this.powerPlayAssist = powerPlayAssist;
        this.shortHandedGoal = shortHandedGoal;
        this.shortHandedAssist = shortHandedAssist;
        this.hits = hits;
    }

    public int toInt(String s){
        return Integer.parseInt(s);
    }
    public String getName() {
		return name;
	}
    public String getTeam() {
        return team;
    }
    public String getPosition(){
        return position;
    }
    public int getGamesPlayed() {
        return toInt(gamesPlayed);
    }
    public int getGoals() {
        return toInt(goals);
    }
    public int getAssists() {
        return toInt(assists);
    }
    public int getPoints() {
        return toInt(points);
    }
    public int getPlusMinus() {
        return toInt(plusMinus);
    }
    public int getPIM() {
        return toInt(penaltyMinutes);
    }
    public int getSOG() {
        return toInt(shotsOnGoal);
    }
    public int getGWG() {
        return toInt(gameWinningGoal);
    }
    public int getPPG() {
        return toInt(powerPlayGoal);
    }
    public int getPPA() {
        return toInt(powerPlayAssist);
    }
    public int getSHG() {
        return toInt(shortHandedGoal);
    }
    public int getSHA() {
        return toInt(shortHandedAssist);
    }
    public int getHits() {
        return toInt(hits);
    }
    public String getConference(ArrayList<Player> p){
        String east = "East";
        String west = "West";
        for(int i=0 ; i<p.size(); i++){
            if(team == "BOS" || team == "NYR" || team == "FLA" || team == "TOR" || 
            team == "NYI" || team == "DET" || team == "PHI" || team == "WSH" ||
             team == "NJD" || team == "CAR" || team == "TBL" || team == "PIT" ||
              team == "MTL" || team == "BUF" || team == "CBJ" || team == "OTT"){
            return east;
        }
        else{
            return west;
        }
        }
        return west;
        
    }
}
