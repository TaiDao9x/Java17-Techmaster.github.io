package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1089_Duplicate_Zeros {
    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == 0) {
                shifting(i + 1, arr);
                arr[i + 1] = 0;
                i++;

            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void shifting(int index, int[] a) {
        for (int i = a.length - 1; i > index; i--) {
            a[i] = a[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
    }
}
