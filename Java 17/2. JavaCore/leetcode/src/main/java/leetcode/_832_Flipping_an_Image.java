package leetcode;

public class _832_Flipping_an_Image {

    // PHÂN TÍCH ĐỀ BÀI:

    // Ta sử dụng hàm for duyệt qua từng hàng-> thực hiện reverve, sau đó thay đổi giá trị 1->0, 0->1.
    // Rồi xét đến từng phần tử trong mảng để thay đổi giá trị trong mảng

    public static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            reverse(image[i]);
            for (int j = 0; j < image[i].length; j++) {

                // Sử dụng hàm điều kiện để thay đổi giá trị
                if (image[i][j] == 1) {
                    image[i][j] = 0;
                } else {
                    image[i][j] = 1;
                }
            }
        }
        return image;
    }

    // Hàm đảo ngược mảng được viết thành 1 method riêng
    public static void reverse(int[] nums) {
        int n = nums.length;

        // Duyệt từ phần tử đầu đến nửa mảng, rồi đổi chỗ các phần tử trong mảng
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 0};
        reverse(a);
    }
}
