package homework_javacore.logic_handle;

import homework_javacore.entity.Score;
import homework_javacore.entity.ScoreDetail;
import homework_javacore.entity.Student;
import homework_javacore.entity.Subject;
import homework_javacore.ultility.Ultility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TranscriptsManagement {
    private List<Score> transcripts;
    private StudentManagement studentManagement;
    private SubjectManagement subjectManagement;

    public TranscriptsManagement(StudentManagement studentManagement, SubjectManagement subjectManagement) {
        this.transcripts = new ArrayList<>();
        this.studentManagement = studentManagement;
        this.subjectManagement = subjectManagement;
    }

    Scanner sc = new Scanner(System.in);

    public void createScoreBoard() {
        System.out.println("Bạn muốn nhập điểm cho bao nhiêu sinh viên?");
        int numberStudent = Ultility.getNumberValid();
        for (int i = 0; i < numberStudent; i++) {

            int idStudent;
            Student student;
            while (true) {
                System.out.print("Nhập vào id của sinh viên thứ " + (i + 1) + " mà bạn muốn nhập điểm: ");
                idStudent = Ultility.getNumberValid();
                student = studentManagement.findByid(idStudent);
                if (student == null) {
                    System.out.println("id sinh viên không tồn tại. Hãy nhập lại!");
                    continue;
                }
                break;
            }

            System.out.print("Bạn muốn nhập điểm cho bao nhiêu môn cho sinh viên này: ");
            int numberSubject = Ultility.getNumberValid();
            List<ScoreDetail> scoreDetails = new ArrayList<>();
            for (int j = 0; j < numberSubject; j++) {
                int subjectId;
                Subject subject;
                while (true) {
                    try {
                        System.out.print("Nhập vào id của môn thứ " + (j + 1) + " : ");
                        subjectId = Integer.parseInt(sc.nextLine());
                        subject = subjectManagement.findById(subjectId);
                        if (subject == null) {
                            System.out.println("Id môn học không tồn tại trong hệ thống. Hãy nhập lại!");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Vui lòng nhập số!");
                    }
                }

                System.out.print("Điểm môn này là: ");
                int score = Ultility.getScore();

                ScoreDetail scoreDetail = new ScoreDetail(subject, score);
                scoreDetails.add(scoreDetail);
            }
            Score score = new Score(student, scoreDetails);
            transcripts.add(score);
        }
        showTranscript();
    }

    public void showTranscript() {
        transcripts.forEach(System.out::println);
    }
}
