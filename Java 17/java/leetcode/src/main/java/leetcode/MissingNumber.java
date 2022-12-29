package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
    }
    public static int missingNumber(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            set.add(nums[i]);
//        }
//        ArrayList<Integer> list = new ArrayList<>();
//        list.addAll(set);
//        int index = nums.length;
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (list.get(i + 1) - list.get(i) == 2) {
//                index = i + 1;
//                break;
//            }
//        }
//        if (!list.contains(0)) {
//            index = 0;
//        }
//        return index;
//

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.sort((o1, o2) -> o1 - o2);

        int index = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (list.get(i + 1) - list.get(i) == 2) {
                index = i + 1;
                break;
            }
        }
        if (!list.contains(0)) {
            index = 0;
        }
        return index;
    }
}
