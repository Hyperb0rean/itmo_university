package pokemon;

import moves.Overheat;

public class Whirlipede extends Venipede{
    public Whirlipede(String name, int level) {
        super(name, level);
        setStats(40,55,99,40,79,47);
        addMove(new Overheat());
    }
}
