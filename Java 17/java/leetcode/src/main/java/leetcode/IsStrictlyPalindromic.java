package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class IsStrictlyPalindromic {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(checkNumbers(n));
    }

    public static boolean checkNumbers(int n) {
        ArrayList<Integer> rs = new ArrayList<>();
        boolean checkPalindromic = false;
        int i;
        for (i = 2; i <= n; i++) {
            while (n > 0) {
                rs.add(n % i);
                n = n / i;
            }
            int[] numbers = new int[rs.size()];
            for (Integer r : rs) {
                numbers[i] = r;
            }
            if (!checkPalindromic(numbers)) {
                break;
            }
        }
        if (i == n) {
            checkPalindromic = true;

        }
        return checkPalindromic;
    }

    public static boolean checkPalindromic(int[] numbers) {
        int[] numbersCompare = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersCompare[i] = numbers[numbers.length - 1 - i];
        }
        return Arrays.equals(numbersCompare, numbers);
    }
}
