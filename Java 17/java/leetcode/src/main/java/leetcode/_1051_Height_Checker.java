package leetcode;

import java.util.Arrays;

public class _1051_Height_Checker {
    public int heightChecker(int[] heights) {
        int[] expected = Arrays.stream(heights).sorted().toArray();
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }
}
