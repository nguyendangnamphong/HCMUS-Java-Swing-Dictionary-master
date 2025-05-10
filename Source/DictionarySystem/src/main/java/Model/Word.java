package Model;

import java.io.Serializable;

public class Word implements Serializable {

    private final int num0 = 0;
    private final int num2 = 2;
    String word;
    String meaning;
    public Word(String word) {
        this.word = word;
    }

    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

     public String parse() {
        String currentMeaning = this.getMeaning();
        String result = "<span color=red>Chữ: </span>" + this.getWord()
            + "<br/>" + "<span color=red>Nghĩa:</span> " + this.getMeaning();
        return result;
    }
}
