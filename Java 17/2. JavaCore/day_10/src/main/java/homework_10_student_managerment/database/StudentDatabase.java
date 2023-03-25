package homework_10_student_managerment.database;

import homework_10_student_managerment.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDatabase {
    public static ArrayList<Student> studentList;

    static {
        studentList = new ArrayList<>(List.of(
                new Student(1, "Đào Văn B", 20, "Vĩnh Phúc", 8.8, "TCNH4a1"),
                new Student(2, "Nguyễn Văn D", 18, "Hà Nội", 9.2, "KT4a2"),
                new Student(3, "Đỗ Văn C", 21, "Thái Nguyên", 7, "TCKD4a2"),
                new Student(4, "Đào Văn E", 20, "Vĩnh Phúc", 8, "TCNH4a1"),
                new Student(5, "Nguyễn Văn A", 22, "Hà Nội", 7.6, "KT4a2"),
                new Student(6, "Đỗ Văn H", 19, "Hà Nội", 6, "QTKD4a2"),
                new Student(7, "Đào Văn G", 23, "Vĩnh Phúc", 8.3, "TCNH4a1"),
                new Student(8, "Nguyễn Văn F", 21, "Hà Nội", 7.7, "QTKD4a2"),
                new Student(9, "Đỗ Văn K", 20, "Hà Nội", 6.8, "Điện 4a2"),
                new Student(10, "Đỗ Văn I", 18, "Hà Nội", 9, "KT4a5")

        ));
        inIt();
    }


    private static void inIt() {

        studentList.add(new Student(11, "Đào Văn A", 20, "Vĩnh Phúc", 8.8, "TCNH4a1"));
        studentList.add(new Student(12, "Nguyễn Văn B", 18, "Hà Nội", 9.2, "KT4a2"));
        studentList.add(new Student(13, "Đỗ Văn C", 21, "Thái Nguyên", 7, "TCKD4a2"));
        studentList.add(new Student(14, "Đào Văn D", 20, "Vĩnh Phúc", 8, "TCNH4a1"));
        studentList.add(new Student(15, "Nguyễn Văn E", 22, "Hà Nội", 7.6, "KT4a2"));
        studentList.add(new Student(16, "Đỗ Văn F", 19, "Hà Nội", 6, "QTKD4a2"));
        studentList.add(new Student(17, "Đào Văn G", 23, "Vĩnh Phúc", 8.3, "TCNH4a1"));
        studentList.add(new Student(18, "Nguyễn Văn H", 21, "Hà Nội", 7.7, "QTKD4a2"));
        studentList.add(new Student(19, "Đỗ Văn I", 20, "Hà Nội", 6.8, "Điện 4a2"));
        studentList.add(new Student(20, "Đỗ Văn K", 18, "Hà Nội", 9, "KT4a5"));
    }
}
