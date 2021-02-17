package avatar;

public abstract class Avatar {

    private String name;
    private int healthPoints;
    private int coinPurse;

    public Avatar(String name, int healthPoints, int coinPurse){
        this.name = name;
        this.healthPoints = healthPoints;
        this.coinPurse = coinPurse;
    }

    public String getName(){
        return this.name;
    };


    public int getHealthPoints(){
        return this.healthPoints;
    };

    public int getCoinPurseCount(){
        return this.coinPurse;
    };
}
