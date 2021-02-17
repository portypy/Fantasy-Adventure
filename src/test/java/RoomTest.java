import enemy.Enemy;
import enemy.EnemyType;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;
import warriors.Dwarf;
import warriors.WeaponType;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    Room room;
    Dwarf dwarf;
    Enemy enemy;

    @Before
    public void before(){
        dwarf = new Dwarf("Hamlett", 100, 10, WeaponType.AXE);
        enemy = new Enemy("Donald", 100, 1, EnemyType.POLITICIAN);
        room = new Room(dwarf, enemy);

    }


@Test
public void hasEnemy(){
    assertEquals( enemy,  room.getEnemy() );
}


@Test
public void hasHero(){
        assertEquals( dwarf, room.getHero());

}

@Test
 public void heroCanDamage(){
        room.attack(dwarf, enemy);
        assertEquals(91, enemy.getHealthPoints());
}



// canHeal

}

