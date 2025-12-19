package game.map;

public class Main {
    public static void main(String[]args){
        Gmmap map=new Gmmap(20,20);
        player p= new player(4);
        map.displaymap();
        map.displaydetail();
        map.stats();
        System.out.println("\n CAN ENTER(5,10)?"+map.canenter(p,5,10));
        System.out.println("CAN ENTER(5,15)?"+map.canenter(p,5,15));
        p.levelUp(); p.levelUp();
        System.out.println("AFTER LEVEL UP CAN ENTER (5,10)?"+map.canenter(p,5,10));
    }
}
