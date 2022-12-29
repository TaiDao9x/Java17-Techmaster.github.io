package leetcode;

public class SubtractProductAndSum {
    public int subtractProductAndSum(int n) {
        int count = 0;
        int m = n;
        while (n > 0) {
            n = n / 10;
            count++;
        }
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = m % 10;
            m = m / 10;
        }
        int product = 1;
        for (int i = 0; i < count; i++) {
            product = product * nums[i];
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += nums[i];
        }
        return product - sum;
    }
}
