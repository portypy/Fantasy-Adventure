package healers;

import avatar.Avatar;
import avatar.IChangeHP;

public class Cleric extends Avatar implements IChangeHP {

    private MedicineType medicineType;

    public Cleric(String name, int healthPoints, int coinPurse, MedicineType medicineType) {
        super(name, healthPoints, coinPurse);
        this.medicineType = medicineType;
    }

    public MedicineType getMedicineType(){
        return this.medicineType;
    }

    public Boolean canFight() {
        return false;
    }

    public int changeHP() {
        return this.medicineType.getHealValue();
    }


    public String whatInHand() {
        return null;
    }

    public void changeMedicine(MedicineType selectedMedicine) {
        this.medicineType = selectedMedicine;
    }
}
