package leetcode;

import java.util.Arrays;
import java.util.OptionalInt;

public class _941_Valid_Mountain_Array {
    public static boolean validMountainArray(int[] arr) {

        if (arr.length < 3) {
            return false;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return false;
            }
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        if (index == (arr.length - 1) || index == 0) {
            return false;
        }
        for (int i = 0; i < index - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        for (int i = index; i < (arr.length - 1); i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {0,3, 2};
        System.out.println(validMountainArray(arr));
    }
}
