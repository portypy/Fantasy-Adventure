package rooms;

import avatar.IChangeHP;
import enemy.Enemy;
import healers.Cleric;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room {

    private ArrayList<IChangeHP> heroes;
    private ArrayList<Enemy> enemies;
    private int coins;

    public Room(ArrayList<IChangeHP> heroes, ArrayList<Enemy> enemies) {
        this.heroes = heroes;
        this.enemies = enemies;
        this.coins = ThreadLocalRandom.current().nextInt(7,44);
    }

    public void attack(IChangeHP hero, Enemy enemy) {
        int damagePoints = hero.changeHP();
        enemy.removeHealthPoints(damagePoints);
        // If enemy is still alive then will counterattack
            if (enemy.getHealthPoints() > 0) {
                int damageFromEnemy = enemy.getEnemyType().getAttackValue();
                hero.removeHealthPoints(damageFromEnemy);
            }
        if (enemies.size() == 0){
            System.out.println("You killed all enemies, treasures are yours!");
            //Share of the treasure for each character
            heroes.forEach(man -> hero.addCoins(Math.floorDiv(heroes.size(), this.coins)));
        } else {
            System.out.println("Enemy still in the room, attack again!");
        }
    }

    public void heal(Cleric cleric, IChangeHP hero){
        int healPoints = cleric.changeHP();
        hero.addHealthPoints(healPoints);
    }
}