package leetcode;

public class _283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}

// Vòng for 1 chạy n lần, vòng for 2 với worst case khi k=0 -> vòng for này sẽ chạy n lần
// => độ phức tạp là: n + n = 2n -> O(n)
