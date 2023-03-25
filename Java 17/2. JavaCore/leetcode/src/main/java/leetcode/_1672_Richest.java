package leetcode;

public class _1672_Richest {
    public int maximumWealth1(int[][] accounts) {
        int[] sum = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[i].length; j++) {
                sum[i] += accounts[i][j];
            }
        }
        int max = 0;

        for (int s : sum) {
            if (s > max) {
                max = s;
            }
        }
        return max;
    }

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] account : accounts) {
            int sum = 0;
            for (int i : account) {
                sum += i;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
