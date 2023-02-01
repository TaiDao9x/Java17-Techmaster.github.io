package leetcode;

public class _485_Max_Consecutive_Ones {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int count = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 1) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (count > max) {
                    max = count;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
