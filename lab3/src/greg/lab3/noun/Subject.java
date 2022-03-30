package greg.lab3.noun;

import greg.lab3.Gender;
import greg.lab3.spec.Adjective;

import java.util.Arrays;


public abstract class Subject extends Noun{
    private Gender gender;
    private Adjective[] adjectives;

    public Subject(String base, Adjective[] adjectives, Gender gender) {
        super(base);
        this.adjectives = adjectives;
        this.gender = gender;
    }

    public Subject(String base, Adjective adjective, Gender gender) {
        super(base);
        Adjective[] adj = new Adjective[1];
        adj[0] = adjective;
        this.adjectives = adj;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  Arrays.toString(adjectives)+ super.toString();
    }

    public Gender getGender() {
        return gender;
    }

    public Adjective[] getSpecs() {
        return adjectives;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setSpecs(Adjective[] specs) {
        this.adjectives = adjectives;
    }


}
