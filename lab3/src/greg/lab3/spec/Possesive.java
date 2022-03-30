package greg.lab3.spec;

import greg.lab3.Gender;

public class Possesive extends Adjective{
    public Possesive(Gender gender, String base) {
        super(gender, base);
    }

    @Override
    public String toString() {
        String res;
        switch (super.getGender()){
            case HE :
                res= "его";
                break;
            case SHE :
                res = "её";
                break;
            case IT :
                res = "их";
                break;
            case APACHEBATTLEHELICOPTER :
                res =  "Тебе точно это нужно?";
                break;
            default : throw new IllegalStateException("Unexpected value: " + super.getGender());
        }
        return res;
    }
}
