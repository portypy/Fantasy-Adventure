import org.junit.Before;
import org.junit.Test;
import warriors.Dwarf;
import warriors.WeaponType;

import static org.junit.Assert.assertEquals;

public class DwarfTest {
    
        Dwarf dwarf;
        
        @Before
        public void before(){
            dwarf = new Dwarf("Hamlett", 100, 10, WeaponType.AXE);
        }


        @Test
        public void hasName(){
                assertEquals("Hamlett", dwarf.getName());
        }

        @Test
        public void hasHealthPoints(){
                assertEquals(100, dwarf.getHealthPoints());
        }

        @Test
        public void hasCoinPurse(){
                assertEquals(10, dwarf.getCoinPurseCount());
        }

        @Test
        public void hasAttributeWeaponType(){
                assertEquals("Axe", dwarf.getWeaponType().getName());
        }

        @Test
        public void canAttack(){
                assertEquals(9, dwarf.attack());
        }

        @Test
        public void canChangeWeapon(){
                dwarf.changeWeapon(WeaponType.AK47);
                assertEquals("Tool", dwarf.getWeaponType().getName());
        }



}