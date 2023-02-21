package day08;

import java.util.Scanner;

public class main {
    public static long fib1(int n) {
        if (n < 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public static long fib2(int n) {
        long[] sum = new long[n + 1];
        sum[0] = 1;
        sum[1] = 1;
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + sum[i - 2];
        }
        return sum[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("N: ");
        int n = sc.nextInt();

        long t0 = System.currentTimeMillis();
        long N1 = fib1(n);
        long t1 = System.currentTimeMillis();

        long N2 = fib2(n);
        long t2 = System.currentTimeMillis();

        System.out.println("N1: " + N1 + ", time: " + (t1 - t0));
        System.out.println("N2: " + N2 + ", time: " + (t2 - t1));
    }
}