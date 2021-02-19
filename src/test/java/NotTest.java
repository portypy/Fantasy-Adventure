import avatar.IChangeHP;
import healers.Cleric;
import healers.MedicineType;
import magicians.MythicalCreatures;
import magicians.SpellType;
import magicians.Wizard;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;
import warriors.Dwarf;
import warriors.WeaponType;

import java.util.ArrayList;

public class NotTest {
    Room room;
    Dwarf dwarf;
    Cleric cleric;
    Wizard oz;


    @Before
    public void before() {
        dwarf = new Dwarf("Thorin", 90, 10, WeaponType.AXE);
        cleric = new Cleric("Medicus", 100, 10, MedicineType.SHROOMS);
        oz = new Wizard("Oz", 100, 10, SpellType.FIREBALL, MythicalCreatures.DRAGON);
        ArrayList<IChangeHP> heroes = new ArrayList<>();
        heroes.add(dwarf);
        heroes.add(cleric);
        heroes.add(oz);
        room = new Room(heroes);
    }

    @Test
    public void thisIsNotTestThisIsRealFightLoL() {

        while (room.getEnemies().size() > 0) {

            for (int x = 0; x < room.getEnemies().size(); x++)  // attacking enemies one by one (smart;)

                while (room.getEnemies().size() > 0 && this.room.getEnemies().get(x).getHealthPoints() > 0) {
                    for (int i = 0; i < room.getHeroes().size(); i++) {        //every hero takes his turn to attack
                        if (this.room.getEnemies().size() == 0) { break; }

                        if (this.room.getHeroes().get(i).getHealthPoints() < 90){ this.room.heal( cleric, this.room.getHeroes().get(i)); }
                            if (this.room.getEnemies().get(x).getHealthPoints() <= 0) { break; }     //prevent continuing loop while enemy killed
                                if (this.room.getHeroes().get(i).canFight())                        // cleric wont fight
                        this.room.attack(this.room.getHeroes().get(i), this.room.getEnemies().get(x));
                    }
            }

        }
    }
}