import java.util.Scanner;

public class ViDu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] mang1;

        mang1 = new double[10];
        double tong = 0;
        for (int i = 0; i < mang1.length; i++) {
            System.out.println("Nhập vào giá trị " + i + " là:");
            mang1[i] = sc.nextDouble();
            tong += mang1[i];
        }
        System.out.println(tong);
    }
}