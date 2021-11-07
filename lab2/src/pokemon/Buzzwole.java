package pokemon;

import moves.Meditate;
import moves.Recover;
import moves.RockTomb;
import moves.WorkUp;
import ru.ifmo.se.pokemon.*;


public class Buzzwole extends Pokemon {
    private String name;
    private int level;

    public Buzzwole(java.lang.String name, int level){

        super(name, level);
        setType(Type.BUG,Type.POISON);
        setStats(107,139,139,53,53,79);
        addMove(new RockTomb());
        addMove(new Meditate());
        addMove(new WorkUp());
        addMove(new Recover());

    }
}
