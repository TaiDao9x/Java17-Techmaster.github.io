package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _217_Contains_Duplicate {

    // Cách 1
    public boolean containsDuplicate(int[] nums) {
        return nums.length != Arrays.stream(nums).distinct().toArray().length;
    }

    // Cách 2
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return nums.length != set.size();
    }
}
