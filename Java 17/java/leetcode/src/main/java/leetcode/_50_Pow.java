package leetcode;

public class _50_Pow {
    public static double myPow(double x, int n) {
        double rs = 0;
        if (n > 0) {
            rs = Math.pow(x, n);
        } else {
            rs = Math.pow(1 / x, -n);

        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2, -2));
    }
}
