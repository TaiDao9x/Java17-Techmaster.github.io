package leetcode;

public class _75_Sort_Colors {

    // PHÂN TÍCH ĐỀ BÀI:
    // Ở bài này ta sử dụng chính phương pháp QUICK SORT
    // Chia bài thành 3 bước:
        // Bước 1: Chọn khóa
        // Bước 2: Dựa vào khóa chia mảng thành 2 phần. Phần bên trái nhỏ hơn khóa, phần bên phải lớn hơn khóa
        // Bước 3: Lặp lại bước chia và bước chọn khóa như trên

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int k = partition(nums, left, right);
        quickSort(nums, left, k - 1);
        quickSort(nums, k + 1, right);
    }

    // Chọn khóa là phần tử cuối cùng bên phải
    // Thực hiện so sánh các phần tử trong mảng để sắp xếp
    public static int partition(int[] nums, int left, int right) {
        int key = nums[right];
        int iL = left;
        int iR = right - 1;

        while (iL <= iR) {
            while (nums[iL] < key) {
                iL++;
            }
            while (iR >= 0 && nums[iR] > key) {
                iR--;
            }
            if (iL <= iR) {
                swap(nums, iL, iR);
                iL++;
                iR--;
            }
        }
        swap(nums, iL, right);
        return iL;
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
