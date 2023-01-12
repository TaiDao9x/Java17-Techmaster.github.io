import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào: ");
        String a = sc.nextLine();
        if (a.equals("")) {
            a = "-";
        }
        System.out.println(a);
    }
}
