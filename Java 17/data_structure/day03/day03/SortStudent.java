package day03;

import java.util.Arrays;
import java.util.Comparator;

public class SortStudent {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Hoàng Phi Hồng", 18, 9),
                new Student("Võ Tòng", 20, 8),
                new Student("Lý Tiểu Long", 21, 9),
                new Student("Lưu Bị", 19, 5),
                new Student("Hoàng Phi Hồng", 20, 7),
                new Student("Trương Phi", 20, 6),
                new Student("Triệu Tử Long", 22, 8),
                new Student("Châu Tinh Trì", 18, 8),
                new Student("Quan Vân Trường", 22, 9),
                new Student("Lữ Bố", 20, 8),
                new Student("Tào Tháo", 25, 10),
                new Student("Gia Cát Lượng", 19, 10)
        };
        //1. Sắp xếp học sinh theo fullName, nếu giống fullName thì ai nhiều tuổi hơn thì đứng trước.
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getFullName().equals(o2.getFullName())) {
                    return o2.getAge() - o1.getAge();
                }
                return o1.getFullName().compareTo(o2.getFullName());
            }
        });
        System.out.println("Sắp xếp học sinh theo fullName, nếu giống fullName thì ai nhiều tuổi hơn thì đứng trước: ");
        for (Student std : students) {
            System.out.println(std);
        }
        System.out.println("-------------------");

        //2. Sắp xếp học sinh theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getAge() != o2.getAge()) {
                    return o1.getAge() - o2.getAge();
                }
                return o2.getGPA() - o1.getGPA();
            }
        });

        System.out.println("Sắp xếp học sinh theo tuổi tăng dần, nếu bằng tuổi thì xếp theo GPA giảm dần: ");
        for (Student std : students) {
            System.out.println(std);
        }
        System.out.println("-------------------");

        //3. Sắp xếp theo tên. (Ví dụ là Hoàng Văn A, thì chỉ xét A thôi)
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getFullName().substring(o1.getFullName().lastIndexOf(" "))
                        .compareTo(o2.getFullName().substring(o2.getFullName().lastIndexOf(" ")));
            }
        });

        System.out.println("Sắp xếp theo tên. (Ví dụ là Hoàng Văn A, thì chỉ xét A thôi): ");
        for (Student std : students) {
            System.out.println(std);
        }
    }
}
