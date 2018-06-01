package dto;

import java.util.Objects;

public class ScoreBoardDTO {

    private String username;
    private int score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBoardDTO that = (ScoreBoardDTO) o;
        return score == that.score &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, score);
    }

    @Override
    public String toString() {
        return "ScoreBoardDTO{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}
