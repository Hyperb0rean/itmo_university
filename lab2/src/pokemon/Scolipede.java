package pokemon;

import moves.DoubleKick;

public class Scolipede extends  Whirlipede{
    public Scolipede(String name, int level) {
        super(name, level);
        setStats(60,100,89,55,69,112);
        addMove(new DoubleKick());
    }
}
