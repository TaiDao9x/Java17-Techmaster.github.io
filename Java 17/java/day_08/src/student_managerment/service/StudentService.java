package student_managerment.service;

import student_managerment.model.Student;

import java.util.Random;
import java.util.Scanner;

public class StudentService {
    public Student createStudent() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int id = rand.nextInt(100) + 1;

        System.out.print("Nhập vào tên học viên:");
        String name = sc.nextLine();

        System.out.print("Nhập vào điểm lý thuyết: ");
        double theoryPoint = sc.nextDouble();

        System.out.print("Nhập vào điểm thực hành: ");
        double practicePoint = sc.nextDouble();

        return new Student(id, name, theoryPoint, practicePoint);
    }

    public double calculateAvgPoint(double theoryPoint, double practicePoint) {
        return (theoryPoint + practicePoint) / 2;
    }

    public void printInfo(Student s) {
        System.out.println("Student{" +
                "id=" + s.id +
                ", name='" + s.name + '\'' +
                ", theoryPoint=" + s.theoryPoint +
                ", practicePoint=" + s.practicePoint +
                '}');
        System.out.println("AvgPoint: "+calculateAvgPoint(s.theoryPoint,s.practicePoint));

    }
}
