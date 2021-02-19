package warriors;

import avatar.Avatar;
import avatar.IChangeHP;


public class Dwarf extends Avatar implements IChangeHP {

    private WeaponType weaponType;

    public Dwarf(String name, int healthPoints, int coinPurse, WeaponType weaponType) {
        super(name, healthPoints, coinPurse);
        this.weaponType = weaponType;
    }


    public WeaponType getWeaponType(){
        return this.weaponType;
    }


    public Boolean canFight() {
        return true;
    }

    public int changeHP() {
        return this.getWeaponType().getDamage();
    }

    public String whatInHand() {
        return this.getWeaponType().getName();
    }


    public void changeWeapon(WeaponType selectWeapon) {
        this.weaponType = selectWeapon;
    }
}