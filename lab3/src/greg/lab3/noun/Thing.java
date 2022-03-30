package greg.lab3.noun;
import greg.lab3.Gender;
import greg.lab3.interfaces.*;
import greg.lab3.spec.Adjective;


public class Thing extends Subject implements SubjectInterface {
    public Thing(String base, Adjective[] adjectives, Gender gender) {
        super(base, adjectives, gender);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String Be() {
        StringBuilder res= new StringBuilder();
        res.append(super.getBase()).append(" ");
        switch (super.getGender()){
            case HE :
                res.append("был");
                break;
            case SHE :
                res.append("была");
                break;
            case IT :
                res.append("было");
                break;
            default : res.append("");
                      break;
        }
        if(super.getSpecs() != null){
            for (Adjective a:super.getSpecs()) {
                res.append(a.toString()).append(" ");
            }
        }
        return res.toString();
    }

    @Override
    public String Stay() {
        StringBuilder res= new StringBuilder();
        if(super.getSpecs() != null){
            for (Adjective a:super.getSpecs()) {
                res.append(a.toString()).append(" ");
            }
        }
        res.append(super.getBase()).append(" ");
        switch (super.getGender()){
            case HE:
                res.append("лежал");
                break;
            case SHE :
                res.append("лежала");
                break;
            case IT :
                res.append("лежало");
                break;
            default: res.append("");
                    break;
        }
        return res.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode()+3;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
