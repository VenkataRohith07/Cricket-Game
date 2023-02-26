import java.util.*;
public class ListOfTeams {

    Player rohit = new Player("Rohit",9,3);
    Player gill = new Player("Gill",8,2);
    Player kohli = new Player("Kohli",10,4);
    Player surya = new Player("Surya",9,2);
    Player rahul = new Player("Rahul",8,2);
    Player hardik = new Player("Hardik",8,7);
    Player arshdeep = new Player("arshdeep",3,7);
    Player ashwin = new Player("Ashwin",6,8);
    Player bumrah = new Player("Bumrah",2,9);
    Player shami = new Player("Shami",3,8);
    Player siraj = new Player("Siraj",2,8);
    Player warner = new Player("Warner",10,2);
    Player finch = new Player("Finch",8,2);
    Player smith= new Player("Smith",9,4);
    Player marnus = new Player("Marnus",8,2);
    Player head = new Player("Head",8,2);
    Player green = new Player("Green",8,6);
    Player starc = new Player("Starc",2,8);
    Player hazlewood = new Player("Hazlewood",2,8);
    Player cummins= new Player("Cummins",6,9);
    Player lyon = new Player("Lyon",2,8);
    Player richard = new Player("Richard",1,7);

   private ArrayList<Player> india = new ArrayList<Player>(Arrays.asList(rohit,gill,kohli,surya,rahul,hardik,arshdeep,ashwin,bumrah,shami,siraj));
   private ArrayList<Player> australia = new ArrayList<Player>(Arrays.asList(warner,finch,smith,marnus,head,green,starc,hazlewood,cummins,lyon,richard));

   private HashMap<Integer,ArrayList<Player>> numberToTeam= new HashMap<>();
   private HashMap<Integer,String> numberToTeamName = new HashMap<>();

    ListOfTeams(){
        numberToTeam.put(1,india);
        numberToTeam.put(2,australia);

        numberToTeamName.put(1,"India");
        numberToTeamName.put(2,"Australia");
    }

    public String getPlayerName(int key,int i){
       return ((numberToTeam.get(key)).get(i)).getName();
    }
    public Player getPlayer(int key,int i){
        return (numberToTeam.get(key)).get(i);
    }
    public String teamName(int key){
        return numberToTeamName.get(key);
    }
    public void teamsList(){
        System.out.println("Team Number :   Team Name :");
        for(int i=1;i<=numberToTeamName.size();i++){
            System.out.println(i+"  "+numberToTeamName.get(i));
        }
    }
 }
