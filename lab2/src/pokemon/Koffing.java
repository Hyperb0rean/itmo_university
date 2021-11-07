package pokemon;

import moves.Facade;
import moves.Screech;
import moves.Swagger;
import ru.ifmo.se.pokemon.*;


public class Koffing extends Pokemon {
    private String name;
    private int level;

    public Koffing(java.lang.String name, int level){

        super(name, level);
        setType(Type.POISON);
        setStats(40,65,95,60,45,35);
        addMove(new Swagger());
        addMove(new Facade());
        addMove(new Screech());
    }
}
