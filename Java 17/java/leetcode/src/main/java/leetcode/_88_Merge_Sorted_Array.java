package leetcode;

import java.util.Arrays;

public class _88_Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m > 0) {
            for (int i = 0; i < n; i++) {
                nums1[m + i] = nums2[i];
            }
        } else {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        sortArray(nums1);
    }

    private static void sortArray(int[] rs) {
        for (int i = 0; i < rs.length; i++) {
            for (int j = i + 1; j < rs.length; j++) {
                if (rs[i] > rs[j]) {
                    int middle = rs[i];
                    rs[i] = rs[j];
                    rs[j] = middle;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
    }
}
