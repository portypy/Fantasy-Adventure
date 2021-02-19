package magicians;

public enum MythicalCreatures {
    OGRE("Shrek", 30, 10, 3),
    DRAGON("Dragon", 50, 15, 5),
    ENT("Treebeard", 40, 20, 10);

    private final String name;
    private final int healthPoints;
    private final int attackValue;
    private final int defBonus;

    MythicalCreatures(String name, int healthPoints, int attackValue, int defBonus){
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackValue = attackValue;
        this.defBonus = defBonus;
    }

    public int getDefBonus() {
        return defBonus;
    }

    public String getName(){
        return this.name;
    }

    public int getHealthPoints(){
        return this.healthPoints;
    }

    public int getAttackValue(){
        return this.attackValue;
    }

}
