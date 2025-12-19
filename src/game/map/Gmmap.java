package game.map;

import java.util.Random;

public class Gmmap {
    private Case[][] grid;
    private int width;
    private int height;
    private region r1=new region ("REGION 1",0);
    private region r2=new region ("REGION 2",5);
    private region r3=new region ("REGION 3",10);

    public Gmmap(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Case[width][height];
        generatemap();
    }
    private region getregionbyrow(int y){
        if (y<=6) return r1;
        else if (y<=13) return r2;
        else return r3;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Case getGrid(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return grid[x][y];
        }
        return null;
    }

    public void setGrid(int x, int y, Case newCase) {
        if (x >= 0 && x < width && y >= 0 && y < height && newCase != null) {
            grid[x][y] = newCase;
        }
    }


    public void generatemap() {
        Random r = new Random();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int ran = r.nextInt(100);
                String terre;
                boolean accesible;
                int bnsDef = 0;
                int bonusatk = 0;
                if (ran < 70) {
                    terre = "grass";
                    accesible = true;
                } else if (ran < 90) {
                    terre = "water";
                    accesible = false;
                } else {
                    terre = "mountain";
                    accesible = true;
                    bnsDef = 2;
                    bonusatk = 1;
                }
                region region =getregionbyrow(y);
                grid[x][y] = new Case(terre, accesible, bnsDef, bonusatk,region);
            }
        }
    }
    public boolean canenter(player p,int x,int y){
        Case c=grid[x][y];
        return c.isAccesible()&&c.getRegion().isUnlock(p);
    }
    public void displaymap(){
        System.out.println("******MAP"+width+"x"+height+"******");
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                System.out.print ("{"+grid[x][y].getsymbol()+"}");
            }
           System.out.println();
        }
    }
    public void displaydetail(){
        System.out.println("\n*********DETAILES*********");
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                Case a=grid[x][y];
                System.out.println("("+x+","+y+"):"+a.getdetail());
            }
        }
    }
    public void stats(){
        int grass=0;
        int water=0;
        int mountain=0;
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                switch (grid[x][y].getTerre()) {
                    case "grass":
                        grass++;
                        break;
                    case "water":
                        water++;
                        break;
                    case "mountain":
                        mountain++;
                        break;
                }
            }
        }
        System.out.println("\n************STATISTICS***************");
        System.out.println("GRASS:"+grass+"cases");
        System.out.println("WATER:"+water+"cases");
        System.out.println("MOUNTAIN:"+mountain+"cases");
        System.out.println("TOTAL:"+(grass+water+mountain)+"cases");
    }
}
