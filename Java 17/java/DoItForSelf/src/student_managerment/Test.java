package student_managerment;

import student_managerment.model.Student;
import student_managerment.service.StudentService;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService st = new StudentService();
        Student st2 = new Student();
        st.createStudent();
        System.out.println(st.calculateAvgPoint(st2.theoryPoint, st2.practicePoint));

        System.out.print("Nhập ten sinh vien: ");
        String s = sc.nextLine();
        st.printInfo(s);
    }

}
