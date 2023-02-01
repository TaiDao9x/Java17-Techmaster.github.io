package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _136_Single_Number {
    public static int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    toRemove.add(nums[i]);
                }
            }
        }
        list.removeAll(toRemove);
        return list.get(0);
    }

    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(singleNumber(nums));
    }
}
