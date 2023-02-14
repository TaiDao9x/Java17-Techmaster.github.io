package day06;

import java.util.Arrays;

public class MyQuickSort {
    public static void main(String[] args) {
        int[] a = {9, 7, 5, 8};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int k = partition(arr, left, right);
        quickSort(arr, left, k - 1);
        quickSort(arr, k + 1, right);

    }

    public static int partition(int[] arr, int left, int right) {
        int key = arr[left];
        int iL = left + 1;
        int iR = right;
        while (iL <= iR) {
            while (iL < arr.length && arr[iL] < key) {
                iL++;
            }
            while ( arr[iR] >= key) {
                iR--;
            }

            if (iL <= iR) {
                swap(arr, iL, iR);
                iL++;
                iR--;
            }

        }
        swap(arr, left, iR);
        return iR;
    }

    public static void swap(int[] arr, int iL, int iR) {
        int temp = arr[iL];
        arr[iL] = arr[iR];
        arr[iR] = temp;
    }
}
