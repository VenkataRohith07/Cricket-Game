
import java.util.*;
public class SetUp {

    public void details(){
        System.out.println(("Konnichiwa!! Welcome to the game"));
        Scanner sc= new Scanner(System.in);
        // taking the team input.
        ListOfTeams selectTeams = new ListOfTeams();
        System.out.println("Enter the team numbers with which you want to play");
        selectTeams.teamsList();
        System.out.println("Enter the first team number: ");
        int x1=sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number of the second team: ");
        int x2=sc.nextInt();
        while(x1==x2){
            System.out.println("Both the teams should not be same, please enter a different number :");
            sc.hasNextLine();
            x2=sc.nextInt();
        }
        sc.nextLine();
        // setting team names
        String teamOneName = selectTeams.teamName(x1);
        String teamTwoName = selectTeams.teamName(x2);
        // toss
        double toss = Math.random()*100;
        int tossVal= (int)toss%4;
        if(tossVal==0 || tossVal==3){
            System.out.println(teamOneName+" has won the toss and decided to bat first.");
        }
        else{
            System.out.println(teamTwoName+" has won the toss and decided to bat first.");
        }
        // selecting format
        System.out.println("The following are the available formats : ");
        System.out.println("t10");
        System.out.println("t20");
        System.out.println("odi");
        System.out.println("Enter the format of the game you want to play :");
        String format=sc.nextLine();
        int overs;
        if(format.equals("t10")){
            overs=10;
        }
        else if (format.equals("t20")) {
            overs=20;
        }
        else if(format.equals("odi")){
            overs=50;
        }
        else{
            overs=5;
        }
        // Making the team bat.
        Batting teamOneBatting = new Batting(overs,Integer.MAX_VALUE);
        Scorecard scoreCardForFirstTeamBatting = new Scorecard(x1,x2,selectTeams);
        System.out.println("Lets see the score card of first batting team");
      //  scoreCardForFirstTeamBatting.printScorecard();
        int runsScoredByTeamOne = teamOneBatting.batting(x1,selectTeams,x2,scoreCardForFirstTeamBatting);
        System.out.println("The chasing team need to chase "+(runsScoredByTeamOne+1)+" to win the game");
        Batting teamtwoBatting = new Batting(overs,runsScoredByTeamOne);
        Scorecard scorecardForSecondTeamBatting = new Scorecard(x2,x1,selectTeams);
        int runsScoredByTeamTwo = teamtwoBatting.batting(x2,selectTeams,x1,scorecardForSecondTeamBatting);
      //  scorecardForSecondTeamBatting.printScorecard();
        if(runsScoredByTeamTwo>=runsScoredByTeamOne){
            System.out.println(teamTwoName+" has won the game.");
        }
        else{
            System.out.println(teamOneName+" has won the game.");
        }
    }
}
