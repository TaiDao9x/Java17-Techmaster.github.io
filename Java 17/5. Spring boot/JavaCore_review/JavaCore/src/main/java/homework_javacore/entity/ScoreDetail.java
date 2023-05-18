package homework_javacore.entity;

public class ScoreDetail {
    private Subject subject;
    private int score;

    public ScoreDetail() {
    }

    public ScoreDetail(Subject subject, int score) {
        this.subject = subject;
        this.score = score;
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

    @Override
    public String toString() {
        return "ScoreDetail{" +
                "subject=" + subject +
                ", score=" + score +
                '}';
    }
}
