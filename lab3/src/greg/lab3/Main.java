package greg.lab3;

import greg.lab3.noun.*;
import greg.lab3.spec.*;


public class Main {

    public static void main(String[] args) {
	    Story story = new Story();

        story.addSentence(new Sentence(new Human("Он",new Quality(Gender.HE,""),Gender.HE).Run(),new Location("улице","по")));
        story.addSentence(new Sentence(new Human("Он",new Quality(Gender.HE,""),Gender.HE).Run(),new Time("минут","через",5),new Location("Космическому городку","к")));
        story.addSentence(new SubSentence(new Human("Он",new Quality(Gender.HE,""),Gender.HE).Run(),new Time("минуту","через",1),new Location("круглую площадь","на"),"а еще"));
        story.addSentence(new SubSentence(new Human("Он",new Quality(Gender.HE,"как вкопанный"),Gender.HE).Stay(),"и"));

        System.out.println(story.toString());
    }

}
