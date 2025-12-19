package game.map;

public class region {
    private String name;
    private int lvlrequied;

    public region (String name, int lvlrequied ){
        this.name=name;
        this.lvlrequied=lvlrequied;
    }
    public boolean isUnlock(player p){
        return p.getLevel()>=lvlrequied;
    }

    public String getName() {
        return name;
    }

    public int getLvlrequied() {
        return lvlrequied;
    }
}
