package leetcode;

import java.util.Arrays;

public class MinimumSum {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(minimumSum(2983)));

        int count = 4;
        int num = 2932;
        int[] nums = new int[count];
        while (num > 0) {
            nums[count - 1] = num % 10;
            num = num / 10;
            count--;
        }
        int x;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    x = nums[i];
                    nums[i] = nums[j];
                    nums[j] = x;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }


    public static int minimumSum(int num) {
        int count = 4;

        int[] nums = new int[count];
        while (num > 0) {
            nums[count - 1] = num % 10;
            num = num / 10;
            count--;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int x = nums[i];
                    nums[i] = nums[j];
                    nums[j] = x;
                }
            }
        }
        int newInt1 = nums[0] * 10 + nums[2];
        int newInt2 = nums[1] * 10 + nums[3];
        return newInt1 + newInt2;
    }
}