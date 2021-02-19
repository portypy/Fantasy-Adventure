package avatar;

public interface IChangeHP {

     Boolean canFight();
     int changeHP();
     int getHealthPoints();
     int getCoinPurseCount();
     void removeCoins(int coins);
     void removeHealthPoints(int points);
     void addHealthPoints(int points);
     void addCoins(int coins);
     String getName();
     String whatInHand();
     default int getDefBonus() {
          return 0;
     }
}
