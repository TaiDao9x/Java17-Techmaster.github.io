package day05;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 4, 9, 12, 19, 25, 31, 46, 50, 57, 72};
        System.out.println(search(nums, 73));
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        return recursion(nums, target, 0, nums.length-1);
    }

    public static int recursion(int[] nums, int target, int left, int right) {

        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return recursion(nums, target, left, right);
    }
}
