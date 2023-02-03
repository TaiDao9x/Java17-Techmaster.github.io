package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _448_Find_All_Numbers_Disappeared {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> rs = new ArrayList<>();
        boolean[] exist = new boolean[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            exist[nums[i]] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!exist[i]) {
                rs.add(i);
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        int[] num = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(num));
    }
}
