package leetcode;

public class SmallestEvenMultiple {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(smallestEvenMultiple(n));
    }

    public static int smallestEvenMultiple(int n) {
        int smallestEvenMultiple = 0;
        if (n == 1 || n == 2) {
            smallestEvenMultiple = 2;
        } else if (n % 2 == 0) {
            smallestEvenMultiple = n;
        } else {
            smallestEvenMultiple = 2 * n;
        }
        return smallestEvenMultiple;
    }
}
