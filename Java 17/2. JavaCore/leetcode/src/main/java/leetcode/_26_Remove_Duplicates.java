package leetcode;

public class _26_Remove_Duplicates {
    public static int removeDuplicates1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; ) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int k = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));


    }
}
