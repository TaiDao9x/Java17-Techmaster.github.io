package homework_javacore.entity;

import java.util.List;

public class Score {
    private Student student;
    private List<ScoreDetail> scoreDetails;

    public Score() {
    }

    public Score(Student student, List<ScoreDetail> scoreDetails) {
        this.student = student;
        this.scoreDetails = scoreDetails;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<ScoreDetail> getTranscriptsDetails() {
        return scoreDetails;
    }

    public void setTranscriptsDetails(List<ScoreDetail> scoreDetails) {
        this.scoreDetails = scoreDetails;
    }

    @Override
    public String toString() {
        return "Transcripts{" +
                "student=" + student +
                ", transcriptsDetails=" + scoreDetails +
                '}';
    }
}
