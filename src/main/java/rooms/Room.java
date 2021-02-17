package rooms;


import avatar.IChangeHP;
import enemy.Enemy;
import healers.Cleric;


import java.util.ArrayList;

public class Room {


    private ArrayList<IChangeHP> heroes;
    private ArrayList<Enemy> enemies;
//    private ArrayList<Treasure> treasures;


    public Room(ArrayList<IChangeHP> heroes, ArrayList<Enemy> enemies) {
        this.heroes = heroes;
        this.enemies = enemies;
    }

    public void attack(IChangeHP hero, Enemy enemy) {
        int damagePoints = hero.changeHP();
        enemy.removeHealthPoints(damagePoints);
        int damageFromEnemy = enemy.getEnemyType().getAttackValue();
        hero.removeHealthPoints(damageFromEnemy);
    }

    public void heal(Cleric cleric, IChangeHP hero){
        int healPoints = cleric.changeHP();
        hero.addHealthPoints(healPoints);
    }
}