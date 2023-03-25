import java.util.Scanner;

public class PractiseScanner01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào số a = ");
        int a = sc.nextInt();
        System.out.println("Nhập vào số b = ");
        int b = sc.nextInt();

        System.out.printf("%d + %d = %d\n", a, b, a + b);
        System.out.printf("%d - %d = %d\n", a, b, a - b);
        System.out.printf("%d * %d = %d\n", a, b, a * b);
        System.out.printf("%d / %d = %.2f\n", a, b, (double) a / b);

        System.out.println(a + "+" + b + "=" + (a + b));
        System.out.println(a + "-" + b + "=" + (a - b));
        System.out.println(a + "*" + b + "=" + (a * b));
        System.out.println(a + "/" + b + "=" + (double) a / b);
        System.out.println(a + "^" + b + "=" + Math.pow(a, b));
        System.out.println(a + "%" + b + "=" + (a % b));
    }
}
