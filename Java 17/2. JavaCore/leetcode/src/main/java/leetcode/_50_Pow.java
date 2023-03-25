package leetcode;

public class _50_Pow {
    public  double myPow(double x, int n) {
        return pow(x, n);
    }

    public double pow(double x, long n) {
        double rs = 0;
        if (n > 0) {
            rs = Math.pow(x, n);
        } else {
            rs = Math.pow(1 / x, -n);

        }
        return rs;
    }

    public static void main(String[] args) {
    }
}
