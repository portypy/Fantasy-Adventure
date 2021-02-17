import magicians.MythicalCreatures;
import magicians.SpellType;
import magicians.Wizard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WizardTest {

    Wizard oz;
    @Before
    public void before(){
        oz = new Wizard("Oz", 100, 10, SpellType.FIREBALL, MythicalCreatures.OGRE);
    }

    @Test
    public void canGetSpellAndCreatureDamage(){
        assertEquals(15, oz.changeHP());
    }

    @Test
    public void canChangeSpellType(){
        oz.changeSpellType(SpellType.LIGHTENINGSTRIKE);
        assertEquals(SpellType.LIGHTENINGSTRIKE, oz.getSpellType());
    }

    @Test
    public void canSetMythicalCreature(){
        oz.setMythicalCreature(MythicalCreatures.DRAGON);
        assertEquals(MythicalCreatures.DRAGON, oz.getMythicalCreature());
    }

    @Test
    public void hasMythicalCreature() {
        assertEquals(MythicalCreatures.OGRE, oz.getMythicalCreature());
    }



}
