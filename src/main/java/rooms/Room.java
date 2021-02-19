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
        String heroAttackMessage = String.format(hero.getName() + " attacks " + enemy.getName() + " with "+ hero.whatInHand() +"! "
                + enemy.getName() + " lost " + damagePoints + "HP");
        System.out.println(heroAttackMessage);
                // If enemy is alive then will counterattack
                    if (enemy.getHealthPoints() > 0) {
                        int damageFromEnemy = enemy.getEnemyType().getAttackValue();
                        hero.removeHealthPoints(damageFromEnemy);
                        String enemyAttackMessage = String.format(enemy.getName() + " counter attacks! "
                                + hero.getName() + " lost " + (damageFromEnemy - hero.getDefBonus())+ "HP");
                        System.out.println(enemyAttackMessage);
                    } else {
                        //Dead enemy removed from the room and his money taken
                        int loot = enemy.getCoinPurseCount();
                        hero.addCoins(loot);
                        int indexOfDeadEnemy = enemies.indexOf(enemy);
                        enemies.remove(indexOfDeadEnemy);
                    }
        if (enemies.size() == 0){
            //Share of the treasure for each hero
            int coinsPerHero = Math.floorDiv(this.coins, heroes.size());
            heroes.forEach(man -> man.addCoins(coinsPerHero));
            System.out.println(String.format("You killed all enemies, treasures are yours! There are "
                    + coinsPerHero + " coins for every Hero."));

            // canExit = true -> go to next room
        } else {
            System.out.println("Enemy still in the room, attack again!");
            System.out.println(" ");
        }
    }

    public void heal(Cleric cleric, IChangeHP hero){
        int healPoints = cleric.changeHP();
        hero.addHealthPoints(healPoints);
        String heroHealedMessage = String.format(cleric.getName() + " healed " + hero.getName() + "! "
                + hero.getName() + " gains " + (healPoints)+ "HP");
        System.out.println(heroHealedMessage);
    }

    public ArrayList<IChangeHP> getHeroes() {
        return heroes;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}