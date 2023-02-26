import java.util.HashMap;

public class Scorecard {
    private HashMap<Player,String> playerToScore =new HashMap<>();
    private HashMap<Player,Integer> playerToWickets = new HashMap<>();
    private HashMap<Player,Integer> playerToOvers = new HashMap<>();

    Scorecard(int battingKey,int bowlingKey,ListOfTeams selectTeams){
        for(int i=0;i<11;i++){
            Player p = selectTeams.getPlayer(battingKey,i);
            playerToScore.put(p,"0(0)");
        }
        for(int i=5;i<11;i++){
            Player p=selectTeams.getPlayer(bowlingKey,i);
            playerToWickets.put(p,0);
            playerToOvers.put(p,0);
        }
    }
    public void setPlayerToScore(Player p,String s){
        playerToScore.put(p,s);
    }
    public void setPlayerToWickets(Player p){
        int x=playerToWickets.get(p);
        playerToWickets.put(p,x+1);
    }
    public void setPlayerToOvers(Player p){
        int x=playerToOvers.get(p);
        playerToOvers.put(p,x+1);
    }
    public void printScorecard(){
        System.out.println("Now about the runs scored by batting team: ");
        playerToScore.forEach((P,S)-> System.out.println(P.getName()+"      "+S));
        System.out.println("Now about the overs bowled and wickets taken: ");
        playerToWickets.forEach((P,W) -> System.out.println(P.getName()+" wik taken: "+W+" overs bowled: "+playerToOvers.get(P)));
    }
}
