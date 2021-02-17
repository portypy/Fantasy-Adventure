import avatar.Avatar;
import avatar.IChangeHP;
import enemy.Enemy;
import enemy.EnemyType;
import healers.Cleric;
import healers.MedicineType;
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
    Enemy enemy;
    ArrayList<Enemy>enemies;
    ArrayList<Avatar>heroes;
    @Before
    public void before(){
        dwarf = new Dwarf("Hamlett", 90, 10, WeaponType.AXE);
        cleric = new Cleric("Max", 100, 2, MedicineType.SHROOMS);
        enemy = new Enemy("Donald", 100, 1, EnemyType.POLITICIAN);
        ArrayList<IChangeHP>heroes = new ArrayList<>();
        ArrayList<Enemy>enemies = new ArrayList<>();
        heroes.add(dwarf);
        enemies.add(enemy);
        heroes.add(cleric);
        room = new Room(heroes, enemies);

    }


@Test
 public void heroCanDamage(){
        room.attack(dwarf, enemy);
        assertEquals(91, enemy.getHealthPoints());
        assertEquals(80, dwarf.getHealthPoints());
}



@Test
    public void clericCanHeal(){
        room.heal(cleric, dwarf);
        assertEquals(140, dwarf.getHealthPoints());
}

}

