package greg.lab3;

import java.util.Arrays;

public class Story {
    private Sentence[] sentences;


    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public void addSentence(Sentence sentence){
        int len =0;
        if(this.sentences != null){
            len = (int) Arrays.stream(this.sentences).count();
        }
        Sentence[] buff = new Sentence[(len+1)];
        for (int i =0; i<len;i++){
            buff[i] = this.sentences[i];
        }
        buff[len] = sentence;
        this.sentences = buff;

    }

    @Override
    public String toString() {
        String res="";
        for( Sentence x: sentences){
            res += x.toString()+".";
        }
        return res;
    }

    public Story(){

    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
