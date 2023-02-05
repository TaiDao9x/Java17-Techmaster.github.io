package leetcode;

import java.util.Arrays;

public class _1051_Height_Checker {
    public static int heightChecker(int[] heights) {
        int[] checked = heights.clone();
        Arrays.sort(checked);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != checked[i]) {
                count++;
            }
        }
        return count;
    }
}
