import healers.Cleric;
import org.junit.Before;
import org.junit.Test;
import rooms.Pyramid;
import rooms.Room;

public class NotTest {
    Pyramid pyramid;
    Cleric cleric;
    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    int roomCounter = 0;
    int totalCoinsLooted = 0;

    @Before
    public void before() {
        pyramid = new Pyramid();
    }

    @Test
    public void thisIsNotTestThisIsRealFightLoL() {
        System.out.printf(ANSI_RED + "Wizard, Cleric and Dwarf enter the pyramid, looking for gold." + ANSI_RESET);
        do {
            Room room = pyramid.createNewRoom();
            roomCounter += 1;
            System.out.println("");
            System.out.printf(ANSI_RED + "They are attacked by " + room.getEnemies().size() + " creatures in the chamber." + ANSI_RESET);
            System.out.println("");
            while (room.getEnemies().size() > 0) {

                for (int x = 0; x < room.getEnemies().size(); x++)  // attacking enemies one by one (smart;)

                    while (room.getEnemies().size() > 0 && room.getEnemies().get(x).getHealthPoints() > 0) {
                        for (int i = 0; i < room.getHeroes().size(); i++) {        //every hero takes his turn to attack
                            if (room.getEnemies().size() == 0) {
                                break;
                            }
                            if (room.getHeroes().get(i).getHealthPoints() < 80) {
                                room.heal(cleric, room.getHeroes().get(i));
                            }
                            if (room.getEnemies().get(x).getHealthPoints() <= 0) {
                                break;
                            }     //prevents continuing loop while enemy killed
                            if (room.getHeroes().get(i).canFight())                        // cleric wont fight
                                room.attack(room.getHeroes().get(i), room.getEnemies().get(x));
                        }
                    }

            } totalCoinsLooted += room.getCoinsLootedInThisRoom();
        } while ( totalCoinsLooted < 200 );  // explore more rooms until heroes have 200 golden coins
        System.out.println(ANSI_RED + "Wizard, Cleric and Dwarf have decided to leave the pyramid, as they looted enough golden coins." + ANSI_RESET);

    }
}
