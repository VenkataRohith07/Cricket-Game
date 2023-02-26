public class Player {
    private final String name;
    private final int battingSkill;
    private final int bowlingSkill;

    Player(String name,int battingSkill,int bowlingSkill){
        this.name=name;
        this.battingSkill=battingSkill;
        this.bowlingSkill=bowlingSkill;
    }
    public int getBattingSkill() {
        return battingSkill;
    }
    public int getBowlingSkill() {
        return bowlingSkill;
    }
    public String getName() {
        return name;
    }
}