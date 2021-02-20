package avatar;

import healers.MedicineType;

public interface IChangeHP {

     Boolean canFight();
     int changeHP();
     int getHealthPoints();
     void removeCoins(int coins);
     void removeHealthPoints(int points);
     void addHealthPoints(int points);
     void addCoins(int coins);
     String getName();
     String whatInHand();
     default int getDefBonus() {
          return 0;
     }
     default MedicineType getMedicineType(){return MedicineType.SHROOMS;};

}
