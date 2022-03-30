package greg.lab3.spec;

import greg.lab3.Gender;

public abstract class Adjective {
    private Gender gender;
    private String base;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Adjective(Gender gender, String base) {
        this.gender = gender;
        this.base = base;
    }

    @Override
    public String toString() {
        return base;
    }
}
