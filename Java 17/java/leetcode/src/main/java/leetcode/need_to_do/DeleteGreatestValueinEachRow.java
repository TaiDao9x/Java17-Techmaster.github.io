package leetcode.need_to_do;

import java.util.Arrays;

public class DeleteGreatestValueinEachRow {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 4}, {3, 3, 1}};
        deleteGreatestValue(grid);
    }

    public static int deleteGreatestValue(int[][] grid) {

        int[] a = new int[grid[1].length];
        System.arraycopy(grid[0], 0, a, 0, grid[1].length);

        int[] b = new int[grid[1].length];
        System.arraycopy(grid[1], 0, b, 0, grid[1].length);
        Arrays.sort(a);
        Arrays.sort(b);
        int rs = 0;
        for (int i = 0; i < a.length; i++) {
            rs += Math.max(a[i], b[i]);
        }
        return rs;
    }
}
