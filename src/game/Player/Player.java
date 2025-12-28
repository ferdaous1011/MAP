package game.Player;
import game.Unit.unit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private int level;
    private ArrayList<unit> units;
    private Map<String, Integer> resources;

    public Player(int level) {
        if (level < 1) {
            this.level = 1;
        } else {
            this.level = level;
        }
        // initialize units list
        units = new ArrayList<>();

        // initialize resources
        resources = new HashMap<>();

        // starting resources
        resources.put("Gold", 500);
        resources.put("Food", 300);
        resources.put("Wood", 200);
        resources.put("Stone", 150);
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
    }

    //units
    public void addunits(unit uniit) {
        if (uniit != null) units.add(uniit);
    }

    public void removedeaduni() {
        units.removeIf(uniit -> !uniit.IsAlive());
    }

    public ArrayList<unit> getUnits() {
        return units;
    }
    public boolean isDead(){
        return units.isEmpty();
    }
    //resource


    public int getResources(String name) {
        return resources.getOrDefault(name, 0);
    }

    public void addResource(String name, int amount) {
        resources.put(name, getResources(name) + amount);
    }

    // check if player has enough resources
    public boolean hasEnough(String name, int amount) {
        return getResources(name) >= amount;
    }

    // spend resource
    public boolean spendResource(String name, int amount) {
        if (hasEnough(name, amount)) {
            resources.put(name, getResources(name) - amount);
            return true;
        }
        return false;
    }
}

