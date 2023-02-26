import java.util.ArrayList;

public class Team {

    private String name;

    public String[] playerName = new String[11];
    public int[] playerRole = new int[11];

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
}
