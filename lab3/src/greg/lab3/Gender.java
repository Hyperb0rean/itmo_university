package greg.lab3;

public enum Gender {
    HE("Он"), SHE("Она"), IT("Оно"), APACHEBATTLEHELICOPTER("McDonnell Douglas AH-64 Apache (Boeing AH-64 Apache)");
    private String pronoun;

    Gender(String pronoun){
        this.pronoun = pronoun;
    }

    public String getPronoun() {
        return pronoun;
    }
}
