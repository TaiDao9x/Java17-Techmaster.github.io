import java.util.Scanner;
import java.util.regex.Pattern;

public class Bai06_Java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String EMAIL_PATTERN = "^[a-zA-Z0-9]+@([\\w]{5,5}+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";

        for (; ; ) {
            System.out.print("\nNhập vào Email của bạn: ");
            String email = sc.nextLine();

            if (Pattern.matches(EMAIL_PATTERN, email)) {
                System.out.println("Email nhập vào hợp lệ");
                break;
            } else {
                System.out.println("Email nhập vào không hợp lệ. Hãy nhập lại!");
            }
        }

        String PHONE_PATTERN = "^(0|\\+84)(\\s|\\.)?[0-9_-]{8,10}$";
        for (; ; ) {
            System.out.print("\nNhập vào số Phone của bạn: ");
            String phone = sc.nextLine();

            if (Pattern.matches(PHONE_PATTERN, phone)) {
                System.out.println("Số phone nhập vào hợp lệ");
                break;
            } else {
                System.out.println("Số phone nhập vào không hợp lệ. Hãy nhập lại!");
            }
        }
    }
}

