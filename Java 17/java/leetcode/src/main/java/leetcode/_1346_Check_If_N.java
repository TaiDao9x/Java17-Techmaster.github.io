package leetcode;

import java.util.Arrays;

public class _1346_Check_If_N {
    public static boolean checkIfExist(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = arr[i] / 2;
            if (Arrays.stream(arr).anyMatch(a -> a == n) && arr[i] % 2 == 0) {
                count++;
            }

        }
        return count > 0;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 14, 11};
        System.out.println(checkIfExist(arr));
    }
}
