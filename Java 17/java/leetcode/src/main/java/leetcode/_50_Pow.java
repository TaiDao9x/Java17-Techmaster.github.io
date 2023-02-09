package leetcode;

public class _50_Pow {
    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        int m = 0;
        if (n < 0) {
            m = n % 2 == 0 ? -(n / 2) : (-n - 1) / 2;
            x = 1 / x;
        } else {
            m = n % 2 == 0 ? (n / 2) : (n - 1) / 2;
        }

        double t = myPow(x, m);
        return n % 2 == 0 ? (t * t) : (x * t * t);

    }

    public static void main(String[] args) {
        System.out.println(myPow(2, 5));
    }
}
