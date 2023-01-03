package leetcode.need_to_do;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int max = 0;
        int rs = 0;
        if (nums.length == 1) {
            rs = nums[0];
        } else {
            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] == nums[j]) {
                        count++;
                        if (count > max) {
                            max = count;
                            rs = nums[i];
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }

        return rs;
    }
}