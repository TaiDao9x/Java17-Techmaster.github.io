package employee_managerment.controler;

import employee_managerment.model.Employee;
import employee_managerment.service.EmployeService;

import java.util.Scanner;

public class EmployeeControler {
    public void runMenu() {
        EmployeService employeService = new EmployeService();
        Scanner sc = new Scanner(System.in);
        boolean isQuit = true;
        while (isQuit) {
            showMenu();
            System.out.print("Nhập vào lựa chọn của bạn: ");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    employeService.printAllEmployee();
                    break;
                case 2:
                    System.out.print("Nhập vào id nhân viên mới: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhập vào tên nhân viên mới: ");
                    String name = sc.nextLine();

                    System.out.print("Nhập vào email nhân viên mới: ");
                    String email = sc.nextLine();

                    System.out.print("Nhập vào luơng nhân viên mới: ");
                    int salary = sc.nextInt();
                    sc.nextLine();

                    Employee employee = new Employee(id, name, email, salary);
                    employeService.addEmployee(employee);
                    break;
                case 3:
                    System.out.print("Nhập vào tên nhân viên muốn tìm kiếm: ");
                    String findName = sc.nextLine();
                    employeService.findByName(findName);
                    break;
                case 4:
                    System.out.print("Nhập vào id nhân viên muốn tìm kiếm: ");
                    int findId = sc.nextInt();
                    sc.nextLine();

                    System.out.println(employeService.findById(findId));
                    break;
                case 5:
                    System.out.print("Nhập vào ID nhân viên muốn xóa: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    employeService.deleteById(deleteId);
                    break;
                case 6:
                    System.out.print("Nhập vào mức lương thấp nhất: ");
                    int minSalary = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhập vào mức lương cao nhất: ");
                    int maxSalary = sc.nextInt();
                    sc.nextLine();

                    employeService.findBySalary(minSalary, maxSalary);
                case 0:
                    isQuit = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        }

    }

    public void showMenu() {
        System.out.println("\n--------- MENU ---------");
        System.out.println(
                "1. In thông tin của tất cả nhân viên\n" +
                        "2. Thêm nhân viên mới (Thông tin của nhân viên được nhập vào từ bàn phím)\n" +
                        "3. Tìm kiếm nhân viên theo name\n" +
                        "4. Tìm kiếm nhân viên theo id\n" +
                        "5. Xóa nhân viên theo id\n" +
                        "6. Tìm kiếm nhân viên có mức lương từ 5.000.000 --> 10.000.000\n" +
                        "0. Thoát");
    }
}
