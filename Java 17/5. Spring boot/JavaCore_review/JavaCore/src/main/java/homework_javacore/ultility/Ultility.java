package homework_javacore.ultility;

import java.util.Scanner;

public class Ultility {
    static Scanner sc = new Scanner(System.in);

    public static int getNumberValid() {
        int option;
        while (true) {
            try {
                System.out.print("Nhập vào lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
                if (option <= 0) {
                    System.out.println("Số nhập vào phải lớn hơn 0. Hãy nhập lại!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ. Hãy nhập số!");
            }
        }
        return option;
    }

    public static int getUnitValid() {
        int option;
        while (true) {
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option < 0) {
                    System.out.println("Số nhập vào phải lớn hơn 0. Hãy nhập lại!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ. Hãy nhập số!");
            }
        }
        return option;
    }

    public static int getSubjectTypeValid() {
        int option;
        while (true) {
            try {
                System.out.print("Nhập vào lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
                if (option < 1 || option > 3) {
                    System.out.println("Số nhập vào từ 1 đến 3. Hãy nhập lại!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ. Hãy nhập số!");
            }
        }
        return option;
    }

    public static int getScore() {
        int option;
        while (true) {
            try {
                System.out.print("Nhập vào lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
                if (option < 0 || option > 10) {
                    System.out.println("Số nhập vào từ 0 đến 10. Hãy nhập lại!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ. Hãy nhập số!");
            }
        }
        return option;
    }

}
