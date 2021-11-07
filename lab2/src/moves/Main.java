package moves;

import pokemon.*;
import ru.ifmo.se.pokemon.*;


public class Main {

    public static void main(String[] args) {
        Battle b = new Battle();
        Koffing p1 = new Koffing("Жаба", 1);
        Weezing p2 = new Weezing("Гадюка", 1);
        Buzzwole p3 = new Buzzwole("Муха", 1);
        Venipede p4 = new Venipede("Таракан", 1);
        Whirlipede p5 = new Whirlipede("Жук", 1);
        Scolipede p6 = new Scolipede("Сколопендра", 1);
        b.addAlly(p1);
        b.addFoe(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addAlly(p5);
        b.addFoe(p6);
        b.go();
    }
}
