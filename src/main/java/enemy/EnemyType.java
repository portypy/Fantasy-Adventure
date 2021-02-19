package enemy;

public enum EnemyType {
    TROLL(10, "Troll", 40, 15),
    TRASHFEEDER(5, "Trashfeeder", 20, 10),
    WEREWOLF(20, "Werewolf", 30, 20),
    GRIFFIN(20, "Griffin",35, 25);


    private final int attackValue;
    private final String name;
    private final int healthPoints;
    private final int coins;

    EnemyType(int attackValue, String name, int healthPoints, int coins) {
        this.attackValue = attackValue;
        this.name = name;
        this.healthPoints = healthPoints;
        this.coins = coins;
    }

    
    public int getAttackValue(){
        return this.attackValue;
    }

    public static EnemyType getRandomEnemyType(){
        return values()[(int) (Math.random() * values().length)];
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getCoins() {
        return coins;
    }
}