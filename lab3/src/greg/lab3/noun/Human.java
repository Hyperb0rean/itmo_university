package greg.lab3.noun;
import greg.lab3.Gender;
import greg.lab3.interfaces.*;
import greg.lab3.spec.Adjective;

import static greg.lab3.Gender.*;

public class Human extends Subject implements HumanInterface, SubjectInterface{



    public Human(String base, Adjective adjective, Gender gender) {
        super(base, adjective, gender);
    }
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String See() {
        StringBuilder res= new StringBuilder();
        if(super.getSpecs() != null){
            for (Adjective a:super.getSpecs()) {
                res.append(a.toString()).append(" ");
            }
        }
        res.append(super.getBase()).append(" ");
        switch (super.getGender()){
            case HE: res.append("видел");
            break;
            case SHE: res.append("видела");
            break;
            default: res.append("");
            break;
        }
        return res.toString();
    }
    @Override
    public  String Run() {
        StringBuilder res= new StringBuilder();
        if(super.getSpecs() != null){
            for (Adjective a:super.getSpecs()) {
                res.append(a.toString()).append(" ");
            }
        }
        res.append(super.getBase()).append(" ");
        switch (super.getGender()){
            case HE :
                res.append("бежал");
                break;
            case SHE :
                res.append("бежала");
                break;
            default: res.append("");
            break;
        }
        return res.toString();
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
            case HE :
                res.append("остановился");
                break;
            case SHE :
                res.append("остановилась");
                break;
            default : res.append("");
                break;
        }
        return res.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 1;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
