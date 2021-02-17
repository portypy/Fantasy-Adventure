package enemy;

public enum EnemyType {
    TROLL(10),
    OGRE(10),
    TAXMAN(10),
    POLITICIAN(10);


    private final int attackValue;

    EnemyType(int attackValue) {
        this.attackValue = attackValue;
    }

    
    public int getAttackValue(){
        return this.attackValue;
    }
}