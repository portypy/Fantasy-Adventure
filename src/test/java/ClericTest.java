import healers.Cleric;
import healers.MedicineType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    Cleric cleric;

    @Before
    public void before(){
        cleric = new Cleric("Max", 100, 2, MedicineType.SHROOMS);
    }

    @Test
    public void hasMedicineType(){
        assertEquals(MedicineType.SHROOMS, cleric.getMedicineType());
    }

    @Test
    public void canHeal(){
        assertEquals(10, cleric.changeHP());
    }


    @Test
    public void canChangeMedicine(){
        cleric.changeMedicine(MedicineType.POTIONS);
        assertEquals(MedicineType.POTIONS, cleric.getMedicineType());
    }

}