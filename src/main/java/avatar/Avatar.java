package avatar;

public abstract class Avatar {

    private String name;
    protected int healthPoints;
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

    public void addHealthPoints(int healthPoints) {
        this.healthPoints += healthPoints;
    }

    public void removeHealthPoints(int damagePoints) {
        this.healthPoints -= damagePoints;
    }

    public void addCoins(int coins) {
        this.coinPurse += coins;
    }

    public void removeCoins(int coins) {
        this.coinPurse -= coins;
    }
}
