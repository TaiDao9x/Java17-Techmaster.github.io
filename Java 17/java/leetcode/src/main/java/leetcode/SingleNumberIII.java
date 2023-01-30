package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        List<Integer> toRemove = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    toRemove.add(nums[i]);
                }
            }
        }
        numbers.removeAll(toRemove);
        int[] rs = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            rs[i] = numbers.get(i);
        }
        return rs;
    }
}
