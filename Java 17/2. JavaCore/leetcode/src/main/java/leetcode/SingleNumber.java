package leetcode;

import java.util.*;

public class SingleNumber {


    public static void main(String[] args) {
        int[] nums = {2, 2, 1};

        singleNumber(nums);
    }

    public static int singleNumber(int[] nums) {
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


        return numbers.get(0);
    }
}
