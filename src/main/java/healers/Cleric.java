package healers;

import avatar.Avatar;

public class Cleric extends Avatar {

    private MedicineType medicineType;

    public Cleric(String name, int healthPoints, int coinPurse, MedicineType medicineType) {
        super(name, healthPoints, coinPurse);
        this.medicineType = medicineType;
    }

    public MedicineType getMedicineType(){
        return this.medicineType;
    }



}
