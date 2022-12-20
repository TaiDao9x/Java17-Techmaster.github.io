package equals.reference;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;


public class Test implements IStudent{
    public static void main(String[] args) {
        // Triển khai functional interface
        Student student = new Student(1, "Bùi Hiên", "hiengmail.com");
        IStudent iStudent = student::printInfo;
        iStudent.display();

        // Tham chiếu đến method của 1 instance
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bùi Hiên", "hiengmail.com"));
        students.add(new Student(2, "Thu Hằng", "hanggmail.com"));
        students.add(new Student(3, "Phương Loan", "loangmail.com"));

        students.forEach(Student::printInfo);
        students.forEach(System.out::println);

        // Sắp xếp theo tên
        students.sort(Comparator.comparing(Student::getName));
        students.forEach(System.out::println);
    }

    @Override
    public void display() {

    }
}
