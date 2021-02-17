package magicians;

public enum SpellType {
    FIREBALL( 5),
    LIGHTENINGSTRIKE( 5);


    private int damageValue;

    SpellType(int damageValue) {
            this.damageValue = damageValue;
    }


    public int getDamageValue(){
        return this.damageValue;
    }
}
