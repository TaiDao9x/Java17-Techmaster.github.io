package leetcode.need_to_do;

public class _219_Contains_Duplicate {

    public static void main(String[] args) {
        int[] num = {99,99};
        System.out.println(containsNearbyDuplicate(num, 2));

    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (nums[i] == nums[j] && (j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
