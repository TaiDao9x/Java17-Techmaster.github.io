package day06;

import java.util.Arrays;

public class MyMergeSort {
    public static void main(String[] args) {
        int[] a1 = {1, 5, 3, 2, 8, 7, 6, 4};
        System.out.println(Arrays.toString(mergerSort(a1, 0, a1.length - 1)));
    }

    public static int[] mergerSort(int[] arr, int left, int right) {
        if (left == right) {
            return new int[]{arr[left]};
        }
        int mid = left + (right - left) / 2;
        int[] a1 = mergerSort(arr, left, mid);
        int[] a2 = mergerSort(arr, mid + 1, right);
        return merge2Arrays(a1, a2);
    }

    public static int[] merge2Arrays(int[] a1, int[] a2) {
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

    public static int[] merge2Arrays2(int[] a1, int[] a2) {
        int[] rs = new int[a1.length + a2.length];

        int k = 0;
        int j = 0;

        for (int i = 0; i < rs.length; i++) {
            if (k == a1.length) {
                rs[i] = a2[j];
                j++;
            } else if (j == a2.length) {
                rs[i] = a1[k];
                k++;
            } else if (a1[k] < a2[j]) {
                rs[i] = a1[k];
                k++;
            } else {
                rs[i] = a2[j];
                j++;
            }
        }
        return rs;
    }


}
