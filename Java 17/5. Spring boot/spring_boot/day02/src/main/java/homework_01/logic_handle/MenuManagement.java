package homework_01.logic_handle;

import java.util.Scanner;

public class MenuManagement {
    private Scanner sc = new Scanner(System.in);

    public void menu() {
        boolean isQuit = false;
        while (!isQuit) {

            showMenu();

            int choice = getOption();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    isQuit = true;
                    break;
                default:
                    System.out.println("Không có lựa chọn này. Vui lòng chọn từ 1 đến 6");
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("--------- QLCN --------");
        System.out.println("1. Nhập danh sách công nhân mới.");
        System.out.println("2. Nhập phân xưởng mới");
        System.out.println("3.");
        System.out.println("0. Thoát");
    }

    public int getOption() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập số!");
                continue;
            }
            checkOption = true;
        }
        return option;
    }
}
