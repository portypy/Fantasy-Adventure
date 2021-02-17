package magicians;

import avatar.Avatar;
import avatar.IChangeHP;

public class Wizard extends Avatar implements IChangeHP {

    SpellType spellType;
    MythicalCreatures mythicalCreature;

    public Wizard(String name, int healthPoints, int coinPurse, SpellType spellType,
                  MythicalCreatures mythicalCreature) {
        super(name, healthPoints, coinPurse);
        this.spellType = spellType;
        this.mythicalCreature = mythicalCreature;

    }

    public SpellType getSpellType() {
        return spellType;
    }

    public MythicalCreatures getMythicalCreature() {
        return mythicalCreature;
    }

    public void setMythicalCreature(MythicalCreatures mythicalCreature) {
        this.mythicalCreature = mythicalCreature;
    }

    public void changeSpellType(SpellType selectSpell) {
        this.spellType = selectSpell;
    }

    // Override original Avatar methods for wizard to use creature
    public int changeHP(){
        return (getSpellType().getDamageValue())+(getMythicalCreature().getAttackValue());
    }

    public void removeHealthPoints(int damagePoints) {
        this.healthPoints -= (damagePoints - getMythicalCreature().getDefBonus());
    }
}
