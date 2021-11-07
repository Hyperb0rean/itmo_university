package pokemon;
import moves.Facade;
import moves.FireBlast;
import ru.ifmo.se.pokemon.*;

public class Venipede extends Pokemon{
    private String name;
    private int level;

    public Venipede(java.lang.String name, int level){

        super(name, level);
        setType(Type.BUG,Type.POISON);
        setStats(30,45,59,30,39,57);
        addMove(new Facade());
        addMove(new FireBlast());


    }
}
