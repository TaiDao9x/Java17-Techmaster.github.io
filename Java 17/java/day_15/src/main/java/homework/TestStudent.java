package homework;

import java.util.ArrayList;
import java.util.List;

public class TestStudent {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Đào Tài", 3, Gender.MALE));
        students.add(new Student(2, "Đỗ Mỹ", 2, Gender.FEMALE));
        students.add(new Student(3, "Đào Đức", 1, Gender.FEMALE));


    }
}
