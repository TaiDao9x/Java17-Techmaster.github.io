package leetcode.need_to_do;

public class IsPowerOfTwo {
    public static void main(String[] args) {
//        System.out.println(isPowerOfTwo(2));

        int x = 1;
        while (x < 16) {

            x = x * 2;
        }
        System.out.println(x);
        System.out.println(Math.log(10) / Math.log(2));
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;

    }
}
