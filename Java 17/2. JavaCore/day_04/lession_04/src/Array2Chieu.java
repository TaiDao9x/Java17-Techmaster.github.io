import java.util.Scanner;

public class Array2Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào số hàng: ");
        int h = sc.nextInt();
        System.out.println("Nhập vào số cột: ");
        int c = sc.nextInt();
        int[][] array = new int[h][c];
        System.out.println("số hàng: " + h + " . Số cột: " + c);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < c; j++) {
                System.out.printf("Nhập vào phần tử B[%d][%d]\n", i, j);
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println("-------");

        int max = array[0][0];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < c; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất trong mảng B là: " + max);
    }
}
