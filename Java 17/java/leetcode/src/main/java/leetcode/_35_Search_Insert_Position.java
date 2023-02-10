package leetcode;

public class _35_Search_Insert_Position {


    public static int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        // Trường hợp target lớn hơn phần tử Max của mảng thì target bị đẩy ra khỏi mảng
        if (target > nums[right]) {
            return nums.length;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // nums = [1,3,5,6], target = 4
    // mid left right   1,3,5,6
    // 1    0   3       1,(3),5,6
    // 2    2   3       1,3,(5),6
    // 2    2   1 -> break vòng while trả về left là đúng

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 4));
    }
}
