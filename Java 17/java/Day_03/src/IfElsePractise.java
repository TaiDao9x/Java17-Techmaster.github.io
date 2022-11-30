import java.util.Scanner;

public class IfElsePractise {
    public static void main(String[] args) {

        // Bài 2
        int mark = 39;
        if (mark >= 85) {
            System.out.println("A");
        } else if (mark >= 70) {
            System.out.println("B");
        } else if (mark >= 40) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }


        // Bài 1
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào chiều cao: ");
        double height = sc.nextDouble();
        System.out.print("Nhâp vào cân nặng: ");
        double weight = sc.nextDouble();

        double bmi = weight / Math.pow(height, 2);
        System.out.printf("bmi = %.2f\n", bmi);
        if (bmi < 18.5) {
            System.out.println("Thiếu cân");
        } else if (bmi > 24.9) {
            System.out.println("Thừa cân");
        } else {
            System.out.println("Bình thường");
        }
    }
}
