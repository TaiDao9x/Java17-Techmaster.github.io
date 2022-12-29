package leetcode;

public class MaximumWealth {
    public int maximumWealth(int[][] accounts) {
        int[] sum = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[j].length; j++) {
                sum[i] += accounts[i][j];
            }
        }
        int max = 0;
        for (int num : sum) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
}
