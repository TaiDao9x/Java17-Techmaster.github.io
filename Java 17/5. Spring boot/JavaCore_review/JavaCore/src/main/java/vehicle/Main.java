package vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    List<Vehicle> vehicleList = new ArrayList<>();


    public static void main(String[] args) {
        Main main = new Main();
        main.runMenu();
    }

    private void runMenu() {
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    inputInfo();
                    for (Vehicle v : vehicleList) {
                        System.out.println(v);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-5s %-5s %-5s\n", "ten", "gia", "dung tich", "thue");
                    for (Vehicle v : vehicleList) {
                        System.out.printf("%-10s %-5d %-5d %-5.2f\n", v.getName(), v.getPrice(), v.getDungTich(), v.getTax());
                    }
                    break;
                case 3:
                    isQuit = true;
                    break;
                default:
                    System.out.println("Khong co lua chon tren. Hay chon lai!");
            }
        }

    }

    private void showMenu() {
        System.out.println("1. Tạo các đối tượng xe và nhập thông tin");
        System.out.println("2. Xuất bảng kê khai tiền thuế của các xe.");
        System.out.println("3. Thoát");
    }

    private int getChoice() {
        boolean isQuit = false;
        int choice = 0;
        while (!isQuit) {
            try {
                System.out.print("Nhap vao lua chon cua ban: ");
                choice = Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le! Hay nhap lai.");
                continue;
            }
            isQuit = true;
        }
        return choice;
    }

    public void inputInfo() {
        System.out.println("Ban muon them moi bao nhieu xe?");
        int vehicleNumber = getChoice();

        for (int i = 0; i < vehicleNumber; i++) {
            Vehicle vehicle = new Vehicle();
            System.out.println("nhap vao ten: ");
            vehicle.setName(sc.nextLine());
            System.out.println("Nhap vao gia: ");
            vehicle.setPrice(Integer.parseInt(sc.nextLine()));
            System.out.println("Nhap vao dung tich: ");
            vehicle.setDungTich(Integer.parseInt(sc.nextLine()));
            vehicleList.add(vehicle);
        }
    }
}
