package home_work;

import home_work.model.Factory;
import home_work.model.Worker;

import java.util.Scanner;

public class Controler {
    Scanner sc = new Scanner(System.in);
    Service service = new Service();

    public void showMenuLogin() {
        System.out.println("\n-----------------------------------------");
        System.out.println("------- WELCOME TO MY COMPANY -------");

        System.out.println("""
                1. Thêm công nhân mới và In ra danh sách công nhân
                2. Nhập danh sách xưởng sản xuất. In ra danh sách xưởng đã có
                3. Bảng danh sách chấm công
                4. Sắp xếp công nhân theo tên
                5. Sắp xếp công nhân theo xưởng
                6. Bảng kê thu nhập mỗi công nhân trong tháng
                0. Thoát
                """);
    }

    public void runMenu() {

        boolean isQuit = false;

        while (!isQuit) {
            showMenuLogin();

            int option = getOption();

            switch (option) {
                case 1 -> {
                    System.out.println("\n----------- THÊM CÔNG NHÂN MỚI -----------");

                    int id = (int) (Math.random() * 10000);
                    System.out.print("Nhập tên Công nhân: ");
                    String name = sc.nextLine();

                    System.out.print("Địa chỉ: ");
                    String address = sc.nextLine();

                    System.out.print("SĐT: ");
                    String phone = sc.nextLine();

                    System.out.print("Bậc thợ: ");
                    int level = Integer.parseInt(sc.nextLine());

                    Worker newWorker = new Worker(id, name, address, phone, level);
                    service.addWorker(newWorker);
                    System.out.println(service.getAllWorker());
                }
                case 2 -> {
                    System.out.println("\n----------- THÊM XƯỞNG -----------");
                    int id = (int) (Math.random() * 1000);
                    System.out.print("Nhập tên xưởng: ");
                    String name = sc.nextLine();

                    System.out.print("Mô tả: ");
                    String description = sc.nextLine();

                    System.out.print("Hệ số công việc: ");
                    double coefficient = Double.parseDouble(sc.nextLine());

                    Factory newFactory = new Factory(id, name, description, coefficient);
                    service.addFactory(newFactory);
                    System.out.println(service.getAllFactories());
                }
                case 3 -> System.out.println("\n----------- CHÂM CÔNG -----------");

                case 4 -> System.out.println("\n----------- DANH SÁCH CN THEO TÊN -----------");

                case 5 -> System.out.println("\n----------- DANH SÁCH CN THEO XƯỞNG -----------");
                case 6 -> System.out.println("\n----------- BẢNG KÊ THU NHẬP -----------");
                case 0 -> {
                    System.out.println("\n----------- HẸN GẶP LẠI! -----------");
                    isQuit = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    public int getOption() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            checkOption = true;
        }
        return option;
    }
}
