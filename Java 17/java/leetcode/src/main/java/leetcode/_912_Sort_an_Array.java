package leetcode;

import java.util.Arrays;

public class _912_Sort_an_Array {

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        System.out.println(Arrays.toString(sortArray(nums)));
    }

    public static int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int k = partition(nums, left, right);
        quickSort(nums, left, k - 1);
        quickSort(nums, k + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int key = nums[right];
        int iL = left;
        int iR = right - 1;

        while (iL <= iR) {
            while (nums[iL] < key) {
                iL++;
            }
            while (iR >= 0 && nums[iR] > key) {
                iR--;
            }
            if (iL <= iR) {
                swap(nums, iL, iR);
                iL++;
                iR--;
            }
        }
        swap(nums, iL, right);
        return iL;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
