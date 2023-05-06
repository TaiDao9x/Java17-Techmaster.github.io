package homework_javacore.logic_handle;

import homework_javacore.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students;

    public StudentManagement() {
        this.students = new ArrayList<>();
    }

    public void inputInfo() {
        System.out.println("Bạn muốn thêm bao nhiêu sinh viên?");
    }
}
