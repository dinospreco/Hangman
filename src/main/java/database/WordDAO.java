package database;

import model.Word;

import java.util.ArrayList;

public interface WordDAO {

    boolean addWord(Word word);
    boolean deleteWord(Word word);
    Word getWordById(int id);
    ArrayList<Word> getAllWords();
    Word getRandomWord();

}
