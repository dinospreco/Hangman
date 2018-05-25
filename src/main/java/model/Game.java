package model;

import java.util.ArrayList;
import java.util.Objects;

public class Game {

    private int gameId;
    private User user;
    private Score score;
    private Word word;
    private int misses;
    private String solutionPlaceholder;
    private String usedLetters;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public int getMisses() {
        return misses;
    }

    public void setMisses(int misses) {
        this.misses = misses;
    }

    public String getUsedLetters() {
        return usedLetters;
    }

    public void setUsedLetters(String usedLetters) {
        this.usedLetters = usedLetters;
    }

    public String getSolutionPlaceholder() {
        return solutionPlaceholder;
    }

    public void setSolutionPlaceholder(String solutionPlaceholder) {
        this.solutionPlaceholder = solutionPlaceholder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return gameId == game.gameId &&
                misses == game.misses &&
                Objects.equals(user, game.user) &&
                Objects.equals(score, game.score) &&
                Objects.equals(word, game.word) &&
                Objects.equals(usedLetters, game.usedLetters);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gameId, user, score, word, misses, usedLetters);
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", user=" + user +
                ", score=" + score +
                ", word=" + word +
                ", misses=" + misses +
                ", usedLetters='" + usedLetters + '\'' +
                '}';
    }
}
