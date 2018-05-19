package model;

import java.util.Objects;

public class Game {

    private int gameId;
    private User user;
    private Score score;
    private String word;
    private int misses;

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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getMisses() {
        return misses;
    }

    public void setMisses(int misses) {
        this.misses = misses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return getGameId() == game.getGameId() &&
                getMisses() == game.getMisses() &&
                Objects.equals(getUser(), game.getUser()) &&
                Objects.equals(getScore(), game.getScore()) &&
                Objects.equals(getWord(), game.getWord());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getGameId(), getUser(), getScore(), getWord(), getMisses());
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", user=" + user +
                ", score=" + score +
                ", word='" + word + '\'' +
                ", misses=" + misses +
                '}';
    }
}
