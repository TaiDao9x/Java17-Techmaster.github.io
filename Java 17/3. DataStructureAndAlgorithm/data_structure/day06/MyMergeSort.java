package day06;

import java.util.Arrays;

public class MyMergeSort {
    public static void main(String[] args) {
        int[] a1 = {7, 9, 6, 1, 4, 5, 8};

        System.out.println(Arrays.toString(mergerSort(a1, 0, a1.length - 1)));
    }

    private static int[] mergerSort(int[] a1, int left, int right) {
        if (left >= right) {
            return new int[]{a1[left]};
        }
        int k = (left + right) / 2;
        int[] a = mergerSort(a1, left, k);
        int[] b = mergerSort(a1, k + 1, right);
        return merge(a, b);
    }

    public static int[] merge(int[] a1, int[] a2) {
        int[] rs = new int[a1.length + a2.length];

        int index = 0;
        int i = 0;
        int j = 0;
        while (i < a1.length && j < a2.length) {
            if (a1[i] < a2[j]) {
                rs[index] = a1[i];
                i++;
            } else {
                rs[index] = a2[j];
                j++;
            }
            index++;
        }
        while (i < a1.length) {
            rs[index] = a1[i];
            i++;
            index++;
        }
        while (j < a2.length) {
            rs[index] = a2[j];
            j++;
            index++;
        }
        return rs;
    }


}
