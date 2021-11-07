package moves;

import ru.ifmo.se.pokemon.*;

public class Meditate extends StatusMove {
    public Meditate() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.ATTACK, 1);

    }

    @Override
    protected String describe() {
        return "использует Meditate";
    }
}
