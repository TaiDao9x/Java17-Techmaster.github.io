package leetcode;

public class _509_Fibonacci_Number {
    public int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}
