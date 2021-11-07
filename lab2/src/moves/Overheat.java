package moves;

import ru.ifmo.se.pokemon.*;

public class Overheat extends SpecialMove {

    public Overheat(){
        super(Type.FIRE,130,90);
    }

    @Override
    protected void applySelfEffects(Pokemon self) {
            self.setMod(Stat.SPECIAL_ATTACK,-2);
    }

    @Override
    protected String describe() {
        return "использует Overheat";
    }
}
