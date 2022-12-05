import java.util.Arrays;
import java.util.Scanner;

public class arrayMultiDimentional {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhập vào số hàng: ");
//        int m = sc.nextInt();
//        System.out.print("Nhập vào số côt: ");
//        int n = sc.nextInt();
//        int[][] arr = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf("Nhập vào phần tử hàng %d, cột %d của mảng: ", i, j);
//                arr[i][j] = sc.nextInt();
//
//            }
//
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//
//        int sum = 0;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (arr[i][j] % 2 == 0) {
//                    sum += arr[i][j];
//                }
//            }
//        }
//        System.out.println("Tổng các số chẵn trong mảng là: " + "\t" + sum);
//
//        int max = arr[0][0];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (arr[i][j] > max) {
//                    max = arr[i][j];
//                }
//            }
//        }
//        System.out.println("Phần tử có giá trị lớn nhất là: " + max);
//
//
//        for (int i = 0; i < m; i++) {
//            int maxRow = arr[i][0];
//            for (int j = 0; j < n; j++) {
//                if (arr[i][j] > maxRow) {
//                    maxRow = arr[i][j];
//                }
//            }
//            System.out.printf("Phần tử lớn nhất của hàng %d là: %d\n", i, maxRow);
//        }

        String[][] arr = new String[10][10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0 || i == arr.length - 1 || j == 0 || j == arr[i].length - 1) {
                    arr[i][j] = "*";
                } else {
                    arr[i][j] = " ";
                }

                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


    }
}
