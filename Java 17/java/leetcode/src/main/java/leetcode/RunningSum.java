package leetcode;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1,1};
        System.out.println(Arrays.toString(runningSum(nums)));

    }

    public static int[] runningSum(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }

        return sum;
    }
}
