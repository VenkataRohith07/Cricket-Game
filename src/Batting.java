public class Batting {

    private int overs;
    private int target;



    Batting(int overs,int target){
        this.overs=overs;
        this.target=target;
    }
    public int rotateStrike(int strike){
        return strike^1;
    }

    private int getRunsScoredInThisBall(int x){
        if(x<=-5){
            return 7;
        }
        else if(x<=0){
            return 0;
        }
        else if(x<=2){
            return 1;
        }
        else if(x<=4){
            return 2;
        }
        else if(x<=6){
            return 3;
        }
        else if(x<=8){
            return 4;
        }
        else if(x<=10){
            return 5;
        }
        return 6;
    }

    public void scoreCard(int wikFallen,int totalScore,String s1,String s2,int oversDone){
        System.out.println("The total number of wickets fallen ; "+ wikFallen);
        System.out.println("The total runs scored by the batting team till now are : "+ totalScore);
        System.out.println("The total number of overs done : "+ oversDone);
        System.out.println(s1);
        System.out.println(s2);
    }
    public int batting(int key,ListOfTeams selectTeams,int bowlingTeamkey,Scorecard scorecard){
        int totalRuns=0;
        int runsScoredInThisBall=0;
        int currBatsMan=2;
        Player p1= selectTeams.getPlayer(key,0);
        Player p2= selectTeams.getPlayer(key,1);
        int bowlersIndex=0;
        Player p3= selectTeams.getPlayer(bowlingTeamkey,bowlersIndex+5);
        int strike=0;
        int oversDoneTillNow=0;
        int ballsDoneInThisOver=0;
        int wikFallenTillNow=0;
        int runsScoredByp1=0;
        int ballsFacedByp1=0;
        int runsScoredByp2=0;
        int ballsFacedByp2=0;
        String overContents="";
        boolean freeHit=false;
        while(oversDoneTillNow<overs && wikFallenTillNow<10 && totalRuns<=target){
            int checkForInvalidBall = (int)(Math.random()*100)%9;
            if(checkForInvalidBall==7){
                totalRuns++;
                overContents=overContents.concat("1WD ");
                System.out.println(oversDoneTillNow+"."+ballsDoneInThisOver+" Well it is a wide.");
            }
            else if(checkForInvalidBall==8){
                totalRuns++;
                overContents= overContents.concat("1NB ");
                freeHit=true;
                System.out.println(oversDoneTillNow+"."+ballsDoneInThisOver+" No Ball it is.And it is a chance for free hit.");
            }
            else{
                int batsManAggression = ((int)(Math.random()*100))%11;
                int batsManSkill;
                if(strike==0){
                    batsManSkill=p1.getBattingSkill();
                }
                else{
                    batsManSkill=p2.getBattingSkill();
                }
                int bowlingSkill=p3.getBowlingSkill();
                int valObtained= (((int)(Math.random()*100)))%(batsManAggression+batsManSkill)-(((int)(Math.random()*100))%bowlingSkill);
                runsScoredInThisBall=getRunsScoredInThisBall(valObtained);
                if(freeHit && runsScoredInThisBall==7){
                    runsScoredInThisBall=0;
                }
                if(runsScoredInThisBall==7){
                    System.out.println(oversDoneTillNow+"."+ballsDoneInThisOver+" What a beauty,It is a Wicket");
                    wikFallenTillNow++;
                    overContents=overContents.concat("W ");
                    scorecard.setPlayerToWickets(p3);
                    if(strike==0){
                        ballsFacedByp1++;
                        scorecard.setPlayerToScore(p1,runsScoredByp1+"("+ballsFacedByp1+")");
                        System.out.println(p1.getName()+":"+runsScoredByp1+"("+ballsFacedByp1+") goes down!!");
                        if(wikFallenTillNow==10){
                            break;
                        }
                        p1= selectTeams.getPlayer(key,currBatsMan);
                        runsScoredByp1=0;
                        ballsFacedByp1=0;
                    }
                    else{
                        ballsFacedByp2++;
                        scorecard.setPlayerToScore(p2,runsScoredByp2+"("+ballsFacedByp2+")");
                        System.out.println(p2.getName()+":"+runsScoredByp2+"("+ballsFacedByp2+") goes down!!");
                        if(wikFallenTillNow==10){
                            break;
                        }
                        p2= selectTeams.getPlayer(key,currBatsMan);
                        runsScoredByp2=0;
                        ballsFacedByp2=0;
                    }
                    currBatsMan++;
                }
                else{
                    freeHit=false;
                    totalRuns+=runsScoredInThisBall;
                    overContents=overContents.concat(runsScoredInThisBall+" ");
                    System.out.println(oversDoneTillNow+"."+ballsDoneInThisOver+" runs scored in this ball are "+runsScoredInThisBall);
                    if(strike==0){
                        runsScoredByp1+=runsScoredInThisBall;
                        ballsFacedByp1++;
                    }
                    else{
                        runsScoredByp2+=runsScoredInThisBall;
                        ballsFacedByp2++;
                    }
                    if(runsScoredInThisBall%2==1){
                       strike= rotateStrike(strike);
                    }
                }
                ballsDoneInThisOver++;
                if(ballsDoneInThisOver==6){
                    scorecard.setPlayerToOvers(p3);
                    oversDoneTillNow++;
                    ballsDoneInThisOver=0;
                    strike= rotateStrike(strike);
                    bowlersIndex++;
                    bowlersIndex%=6;
                    p3=selectTeams.getPlayer(bowlingTeamkey,bowlersIndex+5);
                    System.out.println("The things that happened in this over: "+overContents);
                    System.out.println("The players playing currently are:");
                    System.out.println(p1.getName()+":"+runsScoredByp1+"("+ballsFacedByp1+")");
                    System.out.println(p2.getName()+":"+runsScoredByp2+"("+ballsFacedByp2+")");
                    System.out.println("Runs scored till now are: "+totalRuns);
                    overContents="";
                }

            }
        }
        return totalRuns;
    }


}
