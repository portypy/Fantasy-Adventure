package warriors;

public enum WeaponType {
    SWORD("Excalibur", 12),
    CLUB("Mjölnir", 8),
    AXE("Axe", 9),
    AK47("Tool", 27);


private final String name;
private final int damage;

WeaponType(String name, int damage){
    this.name = name;
    this.damage = damage;
}

    public String getName(){
        return this.name;
    }

    public int getDamage(){
        return this.damage;
    }

}
