package leetcode;

public class _905_Sort_Array_by_parity {

    public int[] sortArrayByParity(int[] nums) {
        int[] rs = new int[nums.length];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                rs[k] = nums[i];
                k++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                rs[k] = nums[i];
                k++;
            }
        }
        return rs;
    }
}
