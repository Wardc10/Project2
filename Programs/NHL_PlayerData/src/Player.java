import java.util.ArrayList;

public class Player {
    private String name, team, position, gamesPlayed, goals,
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
    public ArrayList<String> getConference(ArrayList<Player> p){
        ArrayList<String> conference = new ArrayList<String>();
        for(int i=0 ; i<p.size(); i++){
            if(p.get(i).team == "BOS" || p.get(i).team == "NYR" || p.get(i).team == "FLA" || p.get(i).team == "TOR" || 
                p.get(i).team == "NYI" || p.get(i).team == "DET" || p.get(i).team == "PHI" || p.get(i).team == "WSH" ||
                 p.get(i).team == "NJD" || p.get(i).team == "CAR" || p.get(i).team == "TBL" || p.get(i).team == "PIT" ||
                  p.get(i).team == "MTL" || p.get(i).team == "BUF" || p.get(i).team == "CBJ" || p.get(i).team == "OTT"){
            conference.add(east) ;
            }
            else{
                conference.add(west); 
            }
        }
        return conference; 
    }
}
