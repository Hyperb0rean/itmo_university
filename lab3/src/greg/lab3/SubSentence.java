package greg.lab3;

import greg.lab3.noun.Location;
import greg.lab3.noun.Time;

public class SubSentence extends Sentence{
    private String knot;


    public SubSentence(String base, Time time, Location location, String knot) {
        super(base, time, location);
        this.knot = knot;
    }
    public SubSentence(String base, Location location, String knot) {
        super(base, location);
        this.knot = knot;
    }
    public SubSentence(String base, Time time, String knot) {
        super(base, time);
        this.knot = knot;
    }
    public SubSentence(String base, String knot) {
        super(base);
        this.knot = knot;
    }

    public String getKnot() {
        return knot;
    }

    public void setKnot(String knot) {
        this.knot = knot;
    }

    @Override
    public String toString() {
        return knot+" "+ super.toString();
    }
}
