package leetcode;

import java.util.Arrays;

public class _1346_Check_If_N {
    public static boolean checkIfExist(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 0 && arr[j] == 0) {
                    count++;
                }
            }
        }
        if (count > 0) {
            return true;
        } else {
            count = 0;
            for (int i : arr) {
                int n = i / 2;
                if (Arrays.stream(arr).anyMatch(a -> a == n) && i % 2 == 0 && i != 0) {
                    count++;
                }
            }
        }

        return count > 0;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 0, 11};
        System.out.println(checkIfExist(arr));
    }
}
