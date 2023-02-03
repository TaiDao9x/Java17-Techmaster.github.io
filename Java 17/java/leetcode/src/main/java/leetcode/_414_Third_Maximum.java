package leetcode;

import java.util.Arrays;

public class _414_Third_Maximum {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        if (k < 3) {
            return nums[k - 1];
        }
        return nums[k - 3];
    }

    public static void main(String[] args) {
        int[] num = {3, 2, 1};
        System.out.println(thirdMax(num));
    }
}
