package healers;

public enum MedicineType {
    SHROOMS("Shrooms", 10),
    POTIONS("Potions", 5);

    private final String name;
    private final int healValue;

//    constructor
    MedicineType(String name, int healValue){
        this.name = name;
        this.healValue = healValue;
    }

    public String getMedicineName(){
        return this.name;
    }

    public int getHealValue(){
        return this.healValue;
    }

}
