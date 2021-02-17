package magicians;

public enum MythicalCreatures {
    OGRE("Shrek", 30, 10),
    DRAGON("Smaug", 50, 15),
    ENT("Treebeard", 40, 20);

    private final String name;
    private final int healthPoints;
    private final int defendValue;

    MythicalCreatures(String name, int healthPoints, int defendValue){
        this.name = name;
        this.healthPoints = healthPoints;
        this.defendValue = defendValue;
    }

    public String getName(){
        return this.name;
    }

    public int getHealthPoints(){
        return this.healthPoints;
    }

    public int getDefendValue(){
        return this.defendValue;
    }

}
