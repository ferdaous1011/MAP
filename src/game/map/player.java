package game.map;

public class player {
    private int level;
    public player (int level){
        this.level=level;
    }

    public int getLevel() {
        return level;
    }
    public void levelUp(){
        level++;
    }
}
