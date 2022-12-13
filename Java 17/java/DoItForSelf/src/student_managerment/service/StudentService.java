package student_managerment.service;

import student_managerment.model.Student;

import java.util.Scanner;

public class StudentService {
    Scanner sc = new Scanner(System.in);
    Student student = new Student();

    public Student createStudent() {
        int id = (int) ((Math.random() * 99) + 1);

        System.out.print("Nhap ten sinh vien: ");
        String name = sc.nextLine();

        System.out.print("Nhap diem ly thuyet: ");
        double theoryPoint = sc.nextDouble();

        System.out.print("Nhap diem thuc hanh: ");
        double practicePoint = sc.nextDouble();


        return new Student(id, name, theoryPoint, practicePoint);
    }

    public double calculateAvgPoint(double theoryPoint, double practicePoint) {
        return (theoryPoint + practicePoint) / 2;
    }

    public void printInfo(String s) {

        System.out.println("Thông tin sinh viên: " + student.toString());
        System.out.println("Điêm trung bình là: " + ((student.theoryPoint + student.practicePoint) / 2));

    }
}
