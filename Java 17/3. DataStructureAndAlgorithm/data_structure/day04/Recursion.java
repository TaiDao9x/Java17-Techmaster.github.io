package day04;

import java.util.Arrays;

public class Recursion {
    public static void printF(int n) {
        // Điều kiện dừng của đệ quy
        if (n > 5) {
            return;
        }

        // Công thức quy nạp
        System.out.println("Start:" + n);
        printF(n + 1);
        System.out.println("end: " + n);
    }

    private static int factorial(int n) {

        System.out.println("Start:" + n);
        // điều kiện cơ sở
        if (n == 0) {
            System.out.println("end= " + n);
            return 1;
        }

        // Công thức tổng quát
        int result = n * factorial(n - 1);
        return result;
    }

    private static int fibo2(int n, int[] arr) {
        System.out.println("start: " + n);

        if (n <= 2) {
            return 1;
        }
        if (arr[n] == 0) {
            arr[n] = fibo(n - 1) + fibo(n - 2);
        }
        System.out.println("end: " + n);

        return arr[n];
    }

    private static int fibo(int n) {
//        System.out.println("start: " + n);
        if (n == 2 || n == 1) {
//            System.out.println("end: " + n);
            return 1;
        }
        int rs = fibo(n - 1) + fibo(n - 2);
//        System.out.println("end: " + n);
        return rs;
    }

    // sum từ index = 0 đến n bất kỳ
    private static int sum(int n, int[] arr) {
        if (n < 0) {
            return 0;
        }
        return arr[n] + sum(n - 1, arr);
    }

    // duyệt mảng 2 chiều bằng đệ quy
    private static void Duyet(int i, int j, int[][] arr) {
        if (i < arr.length) {
            if (j < arr[i].length) {
                System.out.println(arr[i][j]);
                Duyet(i, j + 1, arr);
                return;
            }
            Duyet(i + 1, 0, arr);

        }
    }

    private static void Duyet2(int i, int j, int[][] arr) {
        if (i == arr.length) {
            return;
        }

        System.out.println(arr[i][j]);
        if (j < arr[i].length - 1) {
            Duyet2(i, j + 1, arr);
            return;
        }
        Duyet2(i + 1, 0, arr);
    }

    public static void main(String[] args) {
//        int[] arr = new int[1000];
//        System.out.println(fibo2(5, arr));
//
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6}
        };

        Duyet2(0, 0, a);
    }

}
