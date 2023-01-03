package leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class MakeArrayZerobySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        if (set.contains(0)) {
            return set.size() - 1;
        }
        return set.size();
    }
}
