package moves;

import ru.ifmo.se.pokemon.*;

public class NastyPlot extends StatusMove {
    public NastyPlot() {
        super(Type.DARK, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_ATTACK, 2);

    }

    @Override
    protected String describe() {
        return "использует Nasty Plot";
    }
}
