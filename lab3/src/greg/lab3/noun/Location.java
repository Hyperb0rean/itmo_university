package greg.lab3.noun;

public class Location extends Noun{
    private String preposition;

    public Location(String base,String preposition) {
        super(base);
        this.preposition = preposition;
    }

    @Override
    public String toString() {
        return preposition+" "+super.toString();
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    @Override
    public int hashCode() {
        return super.hashCode()+2;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
