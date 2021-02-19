import enemy.EnemyType;
import org.junit.Before;
import org.junit.Test;
import enemy.Enemy;

import static org.junit.Assert.assertEquals;

public class EnemyTest {
    
        Enemy enemy;
        
        @Before
        public void before(){
                enemy = new Enemy("Donald", 100, 1, EnemyType.GRIFFIN);
        }



        @Test
        public void canLooseHealthPoints() {
                enemy.removeHealthPoints(10);
                assertEquals(90, enemy.getHealthPoints());
        }

//        @Test
//        public void hasEnemyType(){
//                assertEquals(EnemyType.WEREWOLF, enemy.getEnemyType());
//        }


}
