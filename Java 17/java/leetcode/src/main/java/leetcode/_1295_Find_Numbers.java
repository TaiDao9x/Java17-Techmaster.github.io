package leetcode;

public class _1295_Find_Numbers {
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int n : nums) {
            if (countNumberDigits(n) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int countNumberDigits(int n) {
        int count = 0;
        int rs = 1;
        while (rs != 0) {
            rs = n / 10;
            n = rs;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{11,2,3,1112}));
    }
}
