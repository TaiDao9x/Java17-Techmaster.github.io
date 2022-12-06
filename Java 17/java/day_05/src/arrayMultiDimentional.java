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


//* * * *
//*     *
//*     *
//*     *
//* * * *
//        String[][] arr = new String[10][10];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if (i == 0 || i == arr.length - 1 || j == 0 || j == arr[i].length - 1) {
//                    arr[i][j] = "*";
//                } else {
//                    arr[i][j] = " ";
//                }
//
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }


//*           *     1
//  *       *       2
//    *   *         3
//      *           4
//    *   *         5
//  *       *       6
//*           *     7
//        String arr[][] = new String[7][7];
//        int number = 0;
//        while (number < arr.length) {
//            for (int i = 0; i < arr[number].length; i++) {
//                arr[number][i] = "  ";
//                arr[number][number] = "* ";
//                arr[number][arr[number].length - number - 1] = "* ";
//                System.out.print(arr[number][i]);
//            }
//            System.out.println();
//            number++;
//
//        }
        int number = 1;
        while (number <= 7) {
            for (int i = 1; i <= 7; i++) {
                if (i == number || i == 8 - number) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            number++;
        }

//*
//* *
//* * *
//* * * *

//        final int HEIGHT = 10;
//        int number = 1;
//        while (number <= HEIGHT) {
//            for (int i = 1; i <= number; i++) {
//                System.out.print("*");
//            }
//            System.out.println();
//            number++;
//        }
//        String arr[][] = new String[4][4];
//        int number = 0;
//        while (number < arr.length) {
//            for (int i = 0; i <= number; i++) {
//                arr[number][i] = "* ";
//
//                System.out.print(arr[number][i]);
//            }
//            System.out.println();
//            number++;
//        }

    }
}
