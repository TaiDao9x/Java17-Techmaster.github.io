package student_managerment;

import student_managerment.model.Student;
import student_managerment.service.StudentService;

public class Test {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        Student std = studentService.createStudent();

        studentService.printInfo(std);

        // Nhập nhiều đối tượng
        Student[] student = new Student[3];
        for (int i = 0; i < student.length; i++) {
            student[i]=studentService.createStudent();
}
    }
}
