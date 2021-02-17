package warriors;

import avatar.Avatar;


public class Dwarf extends Avatar implements IWeapon {

    private WeaponType weaponType;

    public Dwarf(String name, int healthPoints, int coinPurse, WeaponType weaponType) {
        super(name, healthPoints, coinPurse);
        this.weaponType = weaponType;
    }


    public WeaponType getWeaponType(){
        return this.weaponType;
    }



    public int attack() {
        return this.getWeaponType().getDamage();
    }


    public void changeWeapon(WeaponType selectWeapon) {
        this.weaponType = selectWeapon;
    }
}