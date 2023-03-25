package leetcode;


import java.util.Arrays;

class Shuffle {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};

//        shuffle(nums, 3);
        System.out.println(Arrays.toString(shuffle(nums, 3)));
    }

    public static int[] shuffle(int[] nums, int n) {
        int[] nums1 = new int[n];

        for (int i = 0; i < n; i++) {
            nums1[i] = nums[i];
        }
        int[] nums2 = new int[n];
        for (int i = 0; i < n; i++) {
            nums2[i] = nums[i + n];
        }
        int LENGTH_NUM = nums.length;
        int j = 0;
        for (int i = 0; i < LENGTH_NUM; i = i + 2) {
            nums[i] = nums1[j];
            j++;
        }
        int k = 0;
        for (int i = 1; i < LENGTH_NUM; i = i + 2) {
            nums[i] = nums2[k];
            k++;
        }

        return nums;
    }
}