package rooms;

import avatar.Avatar;
import enemy.Enemy;
import warriors.Dwarf;

public class Room {
    private Avatar hero;
    private Enemy enemy;

    public Room(Avatar hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }


    public Avatar getHero() {
        return this.hero;
    }

    public void attack(Dwarf hero, Enemy enemy) {
        int damagePoints = hero.attack();
        enemy.removeHealthPoints(damagePoints);
    }
}
