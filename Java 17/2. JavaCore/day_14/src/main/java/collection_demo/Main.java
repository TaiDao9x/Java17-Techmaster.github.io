package collection_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("John");
        list.add("Victor");
        list.add("Anna");
        list.add("Chris");

        System.out.println("Danh sách ban đầu: ");
        System.out.println(list);

        //Sắp xếp với Collections.sort()
        Collections.sort(list);
        System.out.println("Danh sách sau khi sắp xếp: ");
        System.out.println(list);
        System.out.println("---------");

        // Sắp xếp ngược
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("Danh sách sau khi sắp xếp giảm dần: ");
        System.out.println(list);

        // Đảo vị trí
        Collections.shuffle(list);
        System.out.println("Danh sách sau khi trộn ngẫu nhiên: ");
        System.out.println(list);


        ArrayList<Student> students = new ArrayList<>();
        students.add(new

                Student("John", 8.5));
        students.add(new

                Student("Anna", 9));
        students.add(new

                Student("Victor", 7));
        students.add(new

                Student("Chris", 6.5));

        System.out.println("Danh sách học sinh: ");

        show(students);

        Collections.sort(students);
        System.out.println("Danh sách sau khi sắp xếp: ");

        show(students);


        ArrayList<Student> students2 = new ArrayList<>();
        students.add(new Student("John", 8.5));
        students.add(new Student("Anna", 9));
        students.add(new Student("Victor", 7));
        students.add(new Student("Chris", 6.5));

        System.out.println("Danh sách học sinh: ");
        show(students);

        //Sắp xếp theo tên
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //Cài đặt chỉ tiêu để so sánh trong đây
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Danh sách sắp xếp theo tên: ");
        show(students);

        //Sắp xếp theo điểm
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //Sử dụng toán tử 3 ngôi
                return o2.getPoint() - o1.getPoint() > 0 ? 1 : -1;
            }
        });
        System.out.println("Danh sách sắp xếp theo điểm: ");
        show(students);
    }

    public static void show(ArrayList<Student> list) {
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
