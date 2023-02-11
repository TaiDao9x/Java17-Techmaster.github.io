package day06;

import java.util.Arrays;

public class MyQuickSort {
    public static void main(String[] args) {
        int[] a = {9, 7, 5, 8, 4, 1, 2};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int sortedItem = partition(arr, low, high); // tìm được 1 phần tử sorted
            quickSort(arr, low, sortedItem - 1);
            quickSort(arr, sortedItem + 1, high);

        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int left = low + 1;
        int right = high;
        while (true) {
            while (left <= right && arr[left] < pivot) {
                left++; // tìm đưọc arr[left]>pivot
            }
            while (left <= right && arr[right] > pivot) {
                right--; // tìm được arr[right]<pivot
            }
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
            left++;
            right--;
        }
        swap(arr, low, right);
        return right;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
