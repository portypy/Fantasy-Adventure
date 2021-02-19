import avatar.IChangeHP;
import enemy.Enemy;
import enemy.EnemyType;
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

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room;
    Dwarf dwarf;
    Cleric cleric;
    Wizard oz;
    Enemy enemy;
    Enemy enemy2;

    @Before
    public void before(){
        dwarf = new Dwarf("Hamlett", 90, 10, WeaponType.AXE);
        cleric = new Cleric("Max", 100, 2, MedicineType.SHROOMS);
        oz = new Wizard("Oz", 100, 10, SpellType.FIREBALL, MythicalCreatures.OGRE);
        enemy = new Enemy("Donald", 100, 1, EnemyType.POLITICIAN);
        enemy2 = new Enemy("Harkdh", 15, 2, EnemyType.TROLL);
        ArrayList<IChangeHP>heroes = new ArrayList<>();
        ArrayList<Enemy>enemies = new ArrayList<>();
        heroes.add(dwarf);
        enemies.add(enemy2);
        heroes.add(cleric);
        heroes.add(oz);
        room = new Room(heroes, enemies, 29);

    }


@Test
 public void heroCanAttack(){
        room.attack(dwarf, enemy);
        assertEquals(91, enemy.getHealthPoints());
        assertEquals(80, dwarf.getHealthPoints());
}

@Test
    public void clericCanHeal(){
        room.heal(cleric, dwarf);
        assertEquals(140, dwarf.getHealthPoints());
}

@Test
    public void wizardCanAttack(){
        room.attack(oz, enemy);
         assertEquals(85, enemy.getHealthPoints());
         assertEquals(93, oz.getHealthPoints());
}

@Test
    public void canKillEnemy(){
    room.attack(oz, enemy2);
    assertEquals(0, enemy2.getHealthPoints());
    assertEquals(100, oz.getHealthPoints());
}

}

