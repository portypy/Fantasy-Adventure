package enemy;


public class Enemy {
    private String name;
    private EnemyType enemyType;
    int healthPoints;
    int coinPurse;

    public Enemy(String name, int healthPoints, int coinPurse, EnemyType enemyType) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.coinPurse = coinPurse;
        this.enemyType = enemyType;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getCoinPurseCount() {
        return coinPurse;
    }

    public EnemyType getEnemyType() {
        return this.enemyType;
    }

    public void removeHealthPoints(int damagePoints) {
        this.healthPoints -= damagePoints;
    }
}