package greg.lab3.noun;

public class Time extends Noun{
    private String preposition;
    private int number;


    public Time(String base,String preposition, int number) {
        super(base);
        this.preposition = preposition;
        this.number = number;

    }

    @Override
    public String toString() {
        return preposition+" "+number+" "+super.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    @Override
    public int hashCode() {
        return super.hashCode() - this.number;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
