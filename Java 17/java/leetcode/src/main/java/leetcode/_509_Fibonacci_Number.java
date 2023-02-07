package leetcode;

public class _509_Fibonacci_Number {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
