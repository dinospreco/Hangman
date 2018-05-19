package model;

import java.util.Objects;

public class Score {

    private int scoreId;
    private int userId;
    private int score;

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
        if (!(o instanceof Score)) return false;
        Score score1 = (Score) o;
        return getScoreId() == score1.getScoreId() &&
                getUserId() == score1.getUserId() &&
                getScore() == score1.getScore();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getScoreId(), getUserId(), getScore());
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", userId=" + userId +
                ", score=" + score +
                '}';
    }
}
