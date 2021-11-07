package moves;

import ru.ifmo.se.pokemon.*;


public class DoubleKick extends PhysicalMove {
    public DoubleKick() {
        super(Type.FIGHTING, 30, 100);
    }

    @Override
    protected void applyOppDamage(Pokemon def, double damage) {
        super.applyOppDamage(def,damage);
        super.applyOppDamage(def,damage);
    }

    @Override
    protected String describe() {
        return "использует Double Kick";
    }
}
