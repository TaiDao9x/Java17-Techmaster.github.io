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
                break;
            } catch (NumberFormatException e) {
                System.out.println("Không hợp lệ. Hãy nhập số!");
            }
        }
        return option;
    }
}
