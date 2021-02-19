package rooms;

import avatar.IChangeHP;
import enemy.Enemy;
import enemy.EnemyType;
import healers.Cleric;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Room {

    private ArrayList<IChangeHP> heroes;
    private ArrayList<Enemy> enemies;
    private int coins;

    public Room(ArrayList<IChangeHP> heroes) {
        this.heroes = heroes;
        this.coins = ThreadLocalRandom.current().nextInt(7,44);
//        this.enemies = new ArrayList<>();
        this.enemies = getRandomEnemyList();

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
                        System.out.printf(enemy.getName() + " was killed and his coins taken by " + hero.getName());
                        System.out.println(" ");
                        int indexOfDeadEnemy = enemies.indexOf(enemy);
                        enemies.remove(indexOfDeadEnemy);
                    }
        if (enemies.size() == 0){
            //Share of the treasure for each hero
            int coinsPerHero = Math.floorDiv(this.coins, heroes.size());
            heroes.forEach(man -> man.addCoins(coinsPerHero));
            System.out.printf("You killed all enemies, treasures are yours! There are "
                    + coinsPerHero + " golden coins for every Hero.");

            // canExit = true -> go to next room
        } else {
            System.out.println("Enemy still in the room, attack again!");
            System.out.println(" ");
        }
    }

    public void heal(Cleric cleric, IChangeHP hero){
        int healPoints = cleric.changeHP();
        hero.addHealthPoints(healPoints);
        System.out.println(String.format(cleric.getName() + " healed " + hero.getName() + "! For 5 coins "
                + hero.getName() + " gains " + (healPoints)+ "HP"));
        System.out.println(" ");
        hero.removeCoins(5);
        cleric.addCoins(5);

    }
    public Enemy getRandomEnemy(){
        EnemyType enemyType = EnemyType.getRandomEnemyType();
        String name = enemyType.getName();
        int healthPoints = enemyType.getHealthPoints();
        int coins = enemyType.getCoins();
        Enemy enemy = new Enemy(name, healthPoints, coins, enemyType);
        return enemy;
    }
    public ArrayList<Enemy> getRandomEnemyList(){
        ArrayList<Enemy> randomEnemyList = new ArrayList<>();
        int numberOfEnemies = ThreadLocalRandom.current().nextInt(1,4);
        for (int i = 0; i < numberOfEnemies ; i++) {
            randomEnemyList.add(this.getRandomEnemy());
        }
        return randomEnemyList;
    }

    public ArrayList<IChangeHP> getHeroes() {
        return heroes;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
}