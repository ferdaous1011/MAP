package game.map;
import game.Player.Player;
import game.Unit.Soldat;
public class Main {
    public static void main(String[]args){
        Gmmap map=new Gmmap(20,20);
        Player p= new Player(4);
        map.displaymap();
        map.displaydetail();
        map.stats();
        System.out.println("\n CAN ENTER(5,10)?"+map.canenter(p,5,10));
        System.out.println("CAN ENTER(5,15)?"+map.canenter(p,5,15));
        p.levelUp(); p.levelUp();
        System.out.println("AFTER LEVEL UP CAN ENTER (5,10)?"+map.canenter(p,5,10));
        Player pl = new Player(1);
        System.out.println("Player ready");
        pl.addunits(new Soldat(2,3));
        System.out.println(pl.getUnits().size()); // 1
        System.out.println(pl.spendResource("Gold", 200));//true
    }
}