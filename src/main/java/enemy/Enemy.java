package enemy;

import avatar.Avatar;

public class Enemy extends Avatar {

    private EnemyType enemyType;

    public Enemy(String name, int healthPoints, int coinPurse, EnemyType enemyType) {
        super(name, healthPoints, coinPurse);
        this.enemyType = enemyType;
    }

    public EnemyType getEnemyType(){
        return this.enemyType;
    }
}
