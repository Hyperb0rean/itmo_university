package greg.lab3.noun;

public abstract class Noun {

    private  String base;


    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return base;
    }

    public Noun(String base) {
        this.base = base;
    }
}
