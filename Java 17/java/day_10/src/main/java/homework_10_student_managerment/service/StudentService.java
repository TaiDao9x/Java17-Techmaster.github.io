package homework_10_student_managerment.service;

import homework_10_student_managerment.model.Student;
import homework_10_student_managerment.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();
    ArrayList<Student> allStudents = studentRepository.allStudent();

    public void showAllStudent() {
        formattingDisplayList();
        for (Student student : allStudents) {
            System.out.println(student);
        }
    }

    public void addStudent(Student std) {
        allStudents.add(std);
        System.out.println("Đã thêm học sinh mới thành công! ");
    }

    public void updatePoint(int id, double point) {

        for (Student student : allStudents) {
            if (student.getId() == id) {
                student.setPoint(point);
            }
        }
        System.out.println("Đã cập nhật điểm thành công!");
    }

    public void deleteStudent(int id) {
        ArrayList<Student> ToRemove = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getId() == id) {
                ToRemove.add(student);
            }
        }
        allStudents.removeAll(ToRemove);
        System.out.println("Đã xóa học sinh thành công!");
    }

    public void findStudentByClassoom(String classroom) {
        ArrayList<Student> studentByClassoom = new ArrayList<>();
        for (Student student : allStudents) {
            if (student.getClassroom().toLowerCase().contains(classroom.toLowerCase())) {
                studentByClassoom.add(student);
            }
        }

        if (studentByClassoom.size() > 0) {
            for (Student student : studentByClassoom) {
                System.out.println(student);
            }
        } else {
            System.out.println("Không có học sinh nào lớp: " + classroom);
        }
    }


    public void sortStudentsByName() {
        ArrayList<Student> sortStudentsClone = (ArrayList<Student>) allStudents.clone();

        int STUDENT_CLONE_LENTH = sortStudentsClone.size();

        sortStudentsClone.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));

        for (Student student : sortStudentsClone) {
            System.out.println(student);
        }
    }


    public void sortStudentsByAge() {
        ArrayList<Student> sortStudentsClone = (ArrayList<Student>) allStudents.clone();
        sortStudentsClone.sort(new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        formattingDisplayList();
        for (Student student : sortStudentsClone) {
            System.out.println(student);
        }
    }

    public void sortStudentsByPoint() {
        ArrayList<Student> sortStudentsClone = (ArrayList<Student>) allStudents.clone();

        int STUDENT_CLONE_LENTH = sortStudentsClone.size();

        for (int i = 0; i < STUDENT_CLONE_LENTH; i++) {
            for (int j = i + 1; j < STUDENT_CLONE_LENTH; j++) {
                if (sortStudentsClone.get(i).getPoint() < sortStudentsClone.get(j).getPoint()) {

                    Student middleStudent = sortStudentsClone.get(j);
                    sortStudentsClone.set(j, sortStudentsClone.get(i));
                    sortStudentsClone.set(i, middleStudent);
                }
            }
        }
        formattingDisplayList();
        for (Student student : sortStudentsClone) {
            System.out.println(student);
        }
    }


    // Các method phụ
    public int checkStudentById(int id) {
        ArrayList<Student> findStudentList = new ArrayList<>();
        int count = 0;

        for (Student student : allStudents) {
            if (student.getId() == id) {
                findStudentList.add(student);
                count++;
            }
        }
        return count;
    }

    public void showFindStudentById(int id) {
        ArrayList<Student> findStudentList = new ArrayList<>();
        int count = 0;

        for (Student student : allStudents) {
            if (student.getId() == id) {
                findStudentList.add(student);
                count++;
            }
        }
        if (count > 0) {
            formattingDisplayList();

            for (Student student : allStudents) {
                if (student.getId() == id) {
                    System.out.println(student);
                }
            }
        } else {
            System.out.println("Không có học sinh nào có id: " + id);
        }
    }

    public void formattingDisplayList() {
        System.out.printf("\n%-5s %-20s %-5s %-15s %-10s %-10s\n", "Id", "Name", "Age", "Address", "Point", "Classroom");
    }
}
