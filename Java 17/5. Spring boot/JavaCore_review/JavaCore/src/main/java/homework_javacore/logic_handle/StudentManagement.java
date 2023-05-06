package homework_javacore.logic_handle;

import homework_javacore.entity.Student;
import homework_javacore.ultility.Ultility;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();

//    public StudentManagement() {
//        this.students = new ArrayList<>();
//    }

    public void inputInfo() {
        System.out.println("Bạn muốn thêm bao nhiêu sinh viên?");
        int numberStudent = Ultility.getNumberValid();
        for (int i = 0; i < numberStudent; i++) {
            Student student = new Student();
            student.inputInfo();
            students.add(student);
        }
        showStudent();
    }

    public void showStudent() {
        students.forEach(System.out::println);
    }
}
