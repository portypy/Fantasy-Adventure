package rooms;

import avatar.IChangeHP;
import healers.Cleric;
import healers.MedicineType;
import magicians.MythicalCreatures;
import magicians.SpellType;
import magicians.Wizard;
import warriors.Dwarf;
import warriors.WeaponType;

import java.util.ArrayList;

public class Pyramid {
    Dwarf dwarf;
    Cleric cleric;
    Wizard oz;


    public Pyramid() {

    }



    public Room createNewRoom(){
        ArrayList<IChangeHP> heroes = new ArrayList<>();
        dwarf = new Dwarf("Thorin", 90, 10, WeaponType.AXE);
        cleric = new Cleric("Medicus", 100, 10, MedicineType.SHROOMS);
        oz = new Wizard("Oz", 100, 10, SpellType.FIREBALL, MythicalCreatures.DRAGON);
        heroes.add(dwarf);
        heroes.add(cleric);
        heroes.add(oz);
        Room room = new Room(heroes);
        return room;
    }

//    public int getGold(){
//
//    }
}
