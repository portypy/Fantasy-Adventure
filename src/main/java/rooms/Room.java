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

    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";

    public Room(ArrayList<IChangeHP> heroes) {
        this.heroes = heroes;
        this.coins = ThreadLocalRandom.current().nextInt(7,44);
        this.enemies = getRandomEnemyList();

    }

    public void attack(IChangeHP hero, Enemy enemy) {
        int damagePoints = hero.changeHP();
        enemy.removeHealthPoints(damagePoints);
        String heroAttackMessage = String.format(hero.getName() + " attacks " + enemy.getName() + " with "+ hero.whatInHand() +"! " + enemy.getName() + " lost " + damagePoints + "HP");
        System.out.println(heroAttackMessage);
                // If enemy is alive then will counterattack
                    if (enemy.getHealthPoints() > 0) {
                        int damageFromEnemy = enemy.getEnemyType().getAttackValue();
                        hero.removeHealthPoints(damageFromEnemy);
                        String enemyAttackMessage = String.format(enemy.getName() + " counter attacks! " + hero.getName() + " lost " + (damageFromEnemy - hero.getDefBonus())+ "HP");
                        System.out.println(enemyAttackMessage);
                    } else {
                        //Dead enemy removed from the room and his money taken
                        int loot = enemy.getCoinPurseCount();
                        hero.addCoins(loot);
                        System.out.printf(ANSI_RED + enemy.getName() + " was killed and his coins taken by " + hero.getName() + ANSI_RESET);
                        System.out.println(" ");
                        int indexOfDeadEnemy = enemies.indexOf(enemy);
                        enemies.remove(indexOfDeadEnemy);
                    }
        if (enemies.size() == 0){
            //Share of the treasure for each hero
            int coinsPerHero = Math.floorDiv(this.coins, heroes.size());
            heroes.forEach(man -> man.addCoins(coinsPerHero));
            System.out.printf(ANSI_RED + "You killed all enemies, treasures are yours! There are " + coinsPerHero + " golden coins for every Hero. " + ANSI_RESET);
            System.out.println(" ");
            System.out.printf(this.heroes.get(0).getName() + " has " + this.heroes.get(0).getCoinPurseCount() + ", " + this.heroes.get(1).getName() + " has " + this.heroes.get(1).getCoinPurseCount()+", "+this.heroes.get(2).getName() + " has " + this.heroes.get(2).getCoinPurseCount() + " golden coins.");
            // canExit = true -> go to next room
        } else {
            System.out.println(ANSI_YELLOW + "Enemy still in the room, attack again!" + ANSI_RESET);
            System.out.println(" ");
        }
    }

    public void heal(Cleric cleric, IChangeHP hero){
        int healPoints = this.heroes.get(1).changeHP();
        hero.addHealthPoints(healPoints);
        System.out.println(String.format(ANSI_GREEN  + this.heroes.get(1).getName() + " use " + this.heroes.get(1).getMedicineType() + " and healed " + hero.getName() + "! For 5 coins " + hero.getName() + " gains " + (healPoints)+ "HP" + ANSI_RESET));
        System.out.println(" ");
        hero.removeCoins(5);
        this.heroes.get(1).addCoins(5);

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
        int numberOfEnemies = ThreadLocalRandom.current().nextInt(2,5);
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