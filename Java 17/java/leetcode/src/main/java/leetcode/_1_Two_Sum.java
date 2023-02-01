package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1_Two_Sum {
    public static  int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{i, map.get(x)};
            } else {
                map.put(nums[i], i);
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums={3,3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
