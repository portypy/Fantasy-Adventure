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
    private int coinsTresure;
    private int coinsLootedInThisRoom;

    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_YELLOW = "\u001B[33m";


    public Room(ArrayList<IChangeHP> heroes) {
        this.heroes = heroes;
        this.coinsTresure = ThreadLocalRandom.current().nextInt(7,44);
        this.enemies = getRandomEnemyList();
        this.coinsLootedInThisRoom = 0;

    }

    public void attack(IChangeHP hero, Enemy enemy) {
        int damagePoints = hero.changeHP();
        enemy.removeHealthPoints(damagePoints);
        String heroAttackMessage = String.format(hero.getName() + " attacks " + enemy.getName() + " with "+ hero.whatInHand() +"! " + enemy.getName() + " has lost " + damagePoints + "HP");
        System.out.println(heroAttackMessage);
                // If enemy is alive then will counterattack
                    if (enemy.getHealthPoints() > 0) {
                        int damageFromEnemy = enemy.getEnemyType().getAttackValue();
                        hero.removeHealthPoints(damageFromEnemy);
                        String enemyAttackMessage = String.format(enemy.getName() + " counter attacks! " + hero.getName() + " has lost " + (damageFromEnemy - hero.getDefBonus())+ "HP");
                        System.out.println(enemyAttackMessage);
                    } else {
                        //Dead enemy removed from the room and his money taken
                        int loot = enemy.getCoinPurseCount();
                        hero.addCoins(loot);
                        addToCoinsLootedInThisRoom(loot);
                        System.out.printf(ANSI_RED + enemy.getName() + " has been killed and his coins taken by " + hero.getName() + ANSI_RESET);
                        System.out.println(" ");
                        int indexOfDeadEnemy = enemies.indexOf(enemy);
                        enemies.remove(indexOfDeadEnemy);
                    }
        if (enemies.size() == 0){
            //Share of the treasure for each hero
            int coinsPerHero = Math.floorDiv(this.coinsTresure, heroes.size());
            heroes.forEach(man -> man.addCoins(coinsPerHero));
            addToCoinsLootedInThisRoom(this.coinsTresure);
            System.out.printf(ANSI_RED + "ALL ENEMIES KILLED, TREASURES ARE YOURS! There are " + coinsPerHero + " golden coins for every Hero. " + ANSI_RESET);
            System.out.println(" ");
            System.out.printf(  "Heroes looted " + getCoinsLootedInThisRoom() + " golden coins in this chamber.");
            System.out.println(" ");

        } else {
            System.out.println(ANSI_YELLOW + "Enemy still in the room, attack again!" + ANSI_RESET);
            System.out.println(" ");
        }
    }

    public void heal(Cleric cleric, IChangeHP hero){
        int healPoints = this.heroes.get(1).changeHP();
        hero.addHealthPoints(healPoints);
        System.out.println(String.format(ANSI_GREEN  + this.heroes.get(1).getName() + " uses " + this.heroes.get(1).getMedicineType() + " to heal " + hero.getName() + "! For 5 coins " + hero.getName() + " gains " + (healPoints)+ "HP" + ANSI_RESET));
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

    public int getCoinsLootedInThisRoom() {
        return coinsLootedInThisRoom;
    }

    public void addToCoinsLootedInThisRoom(int coinsLooted) {
        this.coinsLootedInThisRoom += coinsLooted;
    }
}