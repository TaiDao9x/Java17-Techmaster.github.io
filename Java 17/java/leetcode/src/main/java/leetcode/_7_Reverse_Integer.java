package leetcode;

public class _7_Reverse_Integer {
    public static int reverse(int x) {
        int result = 0;
        int sign = x > 0 ? 1 : -1;
        x = x * sign;
        while (x != 0) {
            int digit = x % 10;
            result = result * 10 + digit;
            x = x / 10;
        }
        result = result * sign;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(reverse(3245));
        System.out.println(Integer.MAX_VALUE);
    }

}
