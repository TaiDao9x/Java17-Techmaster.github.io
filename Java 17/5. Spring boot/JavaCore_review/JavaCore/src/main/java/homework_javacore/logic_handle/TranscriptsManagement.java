package homework_javacore.logic_handle;

import homework_javacore.entity.Score;
import homework_javacore.entity.Student;
import homework_javacore.ultility.Ultility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TranscriptsManagement {
    private List<Score> transcripts = new ArrayList<>();
    private StudentManagement studentManagement = new StudentManagement();
    private SubjectManagement subjectManagement = new SubjectManagement();

    Scanner sc = new Scanner(System.in);

    public void createScoreBoard() {
        System.out.println("Bạn muốn nhập điểm cho bao nhiêu sinh viên?");
        int numberStudent = Ultility.getNumberValid();
        for (int i = 0; i < numberStudent; i++) {
            int studentId;
            Student student;
            while (true) {
                try {
                    System.out.print("Nhập vào id của sinh viên thứ " + (i + 1) + " mà bạn muốn nhập điểm: ");
                    studentId = Integer.parseInt(sc.nextLine());
                    student = studentManagement.findByid(studentId);
                    if (student == null) {
                        System.out.println("Id không tồn tại trong hệ thống. Hãy nhập lại!");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số!");
                }
            }

            System.out.print("Bạn muốn nhập điểm cho bao nhiêu môn: ");
            int numberSubject;



        }
    }
}
