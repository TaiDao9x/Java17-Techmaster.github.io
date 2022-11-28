import java.util.Scanner;

public class PractiseScanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


//        Thực hành Scanner
        System.out.print("Nhập vào chuỗi: ");
        String text = sc.nextLine();

        System.out.printf("1. Chuỗi in hoa của chuỗi \"%s\" là: %s\n", text, text.toUpperCase());
        System.out.printf("2. Chuỗi in thường của chuỗi \"%s\" là: %s\n", text, text.toLowerCase());
        System.out.printf("3. Số ký tự của chuỗi \"%s\" là: %d\n", text, text.length());
        System.out.printf("4. Ký tự cuối cùng của chuỗi \"%s\" là: %s\n", text, text.charAt(text.length() - 1));
        System.out.printf("5. 5 ký tự đầu tiên của chuỗi \"%s\" là: %s\n", text, text.substring(0, 5));
        System.out.printf("5. Chuỗi \"%s\" có chứa chuỗi \"hello\" hay không:%s\n ", text, text.contains("hello"));

        //    Thực hành toán tử
        System.out.println("-----------");
        System.out.println("Thực hành toán tử:");
        int a = 10;
        int b = 20;
        a += 10;
        b -= 10;
        System.out.printf("Số a = %d, số b = %d", a, b);
    }
}
