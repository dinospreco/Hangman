package model;

import java.util.Objects;

public class Word {

    private int wordId;
    private String category;
    private String word;

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word1 = (Word) o;
        return getWordId() == word1.getWordId() &&
                Objects.equals(getCategory(), word1.getCategory()) &&
                Objects.equals(getWord(), word1.getWord());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getWordId(), getCategory(), getWord());
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordId=" + wordId +
                ", category='" + category + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}
