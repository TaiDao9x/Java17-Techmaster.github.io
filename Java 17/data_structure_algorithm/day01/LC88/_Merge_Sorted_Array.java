package LC88;

public class _Merge_Sorted_Array {

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 0, 0, 0};
        int[] n2 = {2, 5, 6};
        merge(n1, 3, n2, 3);
        for (int i : n1
        ) {
            System.out.println(i);

        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // tìm vị trí cần insert
        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < m; j++) {
                if (nums2[i] < nums1[j]) {
                    insert(j, nums2[i], m, nums1);
                    m++;
                    break;
                }
            }
        }
    }

    // Thực hiện chèn
    private static void insert(int index, int number, int lengthOfNum1, int[] arr) {
        for (int i = lengthOfNum1 ; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index] = number;
    }
}
