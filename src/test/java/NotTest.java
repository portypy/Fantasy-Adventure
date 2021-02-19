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

public class NotTest {
    Room room;
    Room room2;
    Dwarf dwarf;
    Cleric cleric;
    Wizard oz;
    Enemy enemy;
    Enemy enemy2;
//    ArrayList<Enemy> enemies;
//    ArrayList<Enemy> enemies2;
//    ArrayList<IChangeHP> heroes;

    @Before
    public void before() {
        dwarf = new Dwarf("Thorin", 90, 10, WeaponType.AXE);
        cleric = new Cleric("Medicus", 100, 2, MedicineType.SHROOMS);
        oz = new Wizard("Oz", 100, 10, SpellType.FIREBALL, MythicalCreatures.DRAGON);
        enemy = new Enemy("Smaug", 50, 1, EnemyType.POLITICIAN);
        enemy2 = new Enemy("Harkdh", 30, 2, EnemyType.TROLL);
        ArrayList<IChangeHP> heroes = new ArrayList<>();
        ArrayList<Enemy> enemies = new ArrayList<>();
        heroes.add(dwarf);
        enemies.add(enemy2);
        enemies.add(enemy);
//        heroes.add(cleric);
        heroes.add(oz);
        room = new Room(heroes, enemies);

    }

    @Test
    public void thisIsNotTestThisIsRealFightLoL() {

        while (room.getEnemies().size() > 0) {

            for (int x = 0; x < room.getEnemies().size(); x++)

                while (this.enemy.getHealthPoints() > 0) {
                    for (int i = 0; i < room.getHeroes().size(); i++) {
                        if (this.enemy.getHealthPoints() <= 0) { break; }
                        room.attack(room.getHeroes().get(i), room.getEnemies().get(x));
                    }
            }

        }
    }
}