package day03;

import java.util.Arrays;
import java.util.Comparator;


public class Sort {
    static class Main {
        public static void main(String[] args) {
            int[] arr = {5, 3, 2, 7, 8, 1, 2};
//            selectionSort(arr);

            Arrays.sort(arr);
//            System.out.println(Arrays.toString(arr));

            String[] word = {
                    "Tài", "Anh", "Dũng", "Toàn"
            };
            Arrays.sort(word);
//            System.out.println(Arrays.toString(word));






        }

        public static void bubbleSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                boolean isSwapped = false;
                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isSwapped = true;
                    }
                }
                System.out.println(Arrays.toString(arr));
                if (!isSwapped) {
                    break;
                }
            }
        }


        // sắp xếp chèn
        private static void inserttionSort(int[] arr) {
            for (int i = 1; i < arr.length; i++) {
                int keyNumber = arr[i];
                int j = i - 1; // vị trí bắt đầu duyệt của mảng phía bên trái
                while (j >= 0 && arr[j] > keyNumber) {
                    arr[j + 1] = arr[j]; // dịch sang bên phải để chèn
                    j--;
                }
                arr[j + 1] = keyNumber;

                System.out.print(i + ": ");
                System.out.println(Arrays.toString(arr));
            }
        }

        private static void selectionSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < arr[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;

                System.out.print(i + ": ");
                System.out.println(Arrays.toString(arr));
            }
        }

    }
}
