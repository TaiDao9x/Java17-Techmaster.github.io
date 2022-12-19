package homework_10_student_managerment.controler;

import homework_10_student_managerment.model.Student;
import homework_10_student_managerment.service.StudentService;

import java.util.Scanner;

public class StudentControler {
    StudentService studentService = new StudentService();

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        boolean isOut = true;

        while (isOut) {
            showMenu();
            System.out.print("\nNhập lựa chọn của bạn: ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    System.out.println("\n------DANH SÁCH HỌC SINH------");
                    studentService.showAllStudent();
                    break;
                case 2:
                    System.out.println("\n------THÊM HỌC SINH MỚI------");
                    System.out.print("Nhập Id học sinh mới\t\t: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập tên học sinh mới\t\t: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập tuổi học sinh mới\t\t: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập địa chỉ học sinh mới\t: ");
                    String address = sc.nextLine();

                    System.out.print("Nhập điểm học sinh mới\t\t: ");
                    double point = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập lớp học sinh mới\t: ");
                    String classroom = sc.nextLine();

                    Student newStudent = new Student(id, name, age, address, point, classroom);
                    studentService.addStudent(newStudent);
                    break;
                case 3:
                    System.out.println("\n------CẬP NHẬT ĐIỂM HỌC SINH------ ");
                    System.out.print("Id của học sinh muốn cập nhật\t: ");
                    int idUpdate = Integer.parseInt(sc.nextLine());
                    studentService.showFindStudentById(idUpdate);

                    if (studentService.checkStudentById(idUpdate) > 0) {
                        System.out.print("\nNhập điểm mới\t\t: ");
                        double pointUpdate = Integer.parseInt(sc.nextLine());
                        studentService.updatePoint(idUpdate, pointUpdate);
                    }

                    break;
                case 4:
                    System.out.println("\n------XÓA HỌC SINH------ ");
                    System.out.print("Id của học sinh muốn xóa\t: ");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    studentService.showFindStudentById(idDelete);

                    if (studentService.checkStudentById(idDelete) > 0) {
                        int answer = 0;

                        while (answer != 2) {
                            subMenu();
                            answer = Integer.parseInt(sc.nextLine());
                            if (answer == 1) {
                                studentService.deleteStudent(idDelete);
                                answer = 2;
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n------TÌM HỌC SINH THEO LỚP------ ");
                    System.out.print("Lớp muốn tìm \t: ");
                    String classroomName = sc.nextLine();
                    studentService.findStudentByClassoom(classroomName);
                    break;
                case 6:
                    System.out.println("\n------SẮP XẾP HỌC SINH THEO TÊN------");
                    studentService.sortStudentsByName();
                    break;
                case 7:
                    System.out.println("\n------SẮP XẾP HỌC SINH THEO TUỔI------");
                    studentService.sortStudentsByAge();
                    break;
                case 8:
                    System.out.println("\n------SẮP XẾP HỌC SINH THEO ĐIỂM------");
                    studentService.sortStudentsByPoint();
                    break;
                case 0:
                    isOut = false;
                    break;
            }
        }
    }

    public void showMenu() {
        System.out.println("\n------------MENU------------");
        System.out.println(
                "1. Xem danh sách học sinh\n" +
                        "2. Thêm học sinh mới\n" +
                        "3. Cập nhật điểm học sinh\n" +
                        "4. Xóa học sinh\n" +
                        "5. Xem danh sách học sinh theo lớp\n" +
                        "6. Sắp xếp theo tên\n" +
                        "7. Sắp xếp theo tuổi\n" +
                        "8. Sắp xếp theo điểm\n" +
                        "0. Thoát");
    }

    public void subMenu() {
        System.out.println("\nBạn có thực sự muốn xóa? ");
        System.out.println("1. Có \t\t 2. Không");
        System.out.print("Bạn chọn \t\t: ");
    }
}
