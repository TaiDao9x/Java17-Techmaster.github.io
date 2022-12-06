package onlab;

import java.util.Arrays;
import java.util.Scanner;

public class Array2dDemo {
    public static void main(String[] args) {
        int[][] numbersOther = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };

        for (int i = 0; i < numbersOther.length; i++) {
            System.out.println(Arrays.toString(numbersOther[i]));
            System.out.println();

            for (int j = 0; j < numbersOther[i].length; j++) {
                System.out.println(numbersOther[i][j]);
            }
        }

        for (int[] row : numbersOther) {
            for (int number : row) {
                System.out.println(number);
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng: ");
        int row = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int col = sc.nextInt();
        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Nhập vào phần tử thứ %d %d: ", i, j);
                arr[i][j] = sc.nextInt();
            }
        }

        for (int[] array : arr) {
            for (int number : array) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
