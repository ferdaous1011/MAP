package game.map;

 public class Case {
   private String terre;
    private boolean accesible;
    private int bnsDef;
    private int bonusatk;
    private region region;

    public Case(String terre,boolean accesible,int bnsDef,int bonusatk, region region){
        this.terre=terre;
        this.accesible=accesible;
        this.bnsDef=bnsDef;
        this.bonusatk=bonusatk;
        this.region=region;

    }

    public String getTerre() {
        return terre;
    }

    public int getBnsDef() {
        return bnsDef;
    }

    public int getBonusatk() {
        return bonusatk;
    }

    public boolean isAccesible() {
        return accesible;
    }

    public void setBonusatk(int bonusatk) {
        this.bonusatk = bonusatk;
    }

    public void setAccesible(boolean accesible) {
        this.accesible = accesible;
    }

    public void setBnsDef(int bonusDef) {
        this.bnsDef = bonusDef;
    }

    public region getRegion() {
        return region;
    }

    public void setTerre(String terre) {
        this.terre = terre;
    }
    public String getsymbol(){
        switch (terre){
            case "grass":return"gr";
            case "water":return"wtr";
            case "mountain":return"mntn";
            default : return "!";
        }
    }
    public String getdetail(){
       return terre+"(accesible:"+accesible+"  def:"+bnsDef+"  ATK:"+bonusatk+")";
    }
}
