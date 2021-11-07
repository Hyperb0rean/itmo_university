package moves;

import ru.ifmo.se.pokemon.*;

public class Recover extends StatusMove {
    public Recover() {
        super(Type.DARK, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, -((int) ((Math.random() * (107/2)))));

    }

    @Override
    protected String describe() {
        return "использует Recover";
    }
}
