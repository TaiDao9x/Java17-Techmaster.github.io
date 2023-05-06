package homework_javacore.entity;

public class ScoreDetail {
    private Subject subject;
    private int score;

    public ScoreDetail() {
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
