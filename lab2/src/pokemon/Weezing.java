package pokemon;

import moves.NastyPlot;

public class Weezing extends  Koffing{
    public Weezing(String name, int level) {
        super(name, level);
        setStats(65,90,120,85,70,60);
        addMove(new NastyPlot());
    }
}
