package leetcode;

public class _1512_Number_of_Good_Pairs {

    // PHÂN TÍCH ĐỀ BÀI:
    // Theo đề bài ta phải đếm số cặp số bằng nhau trong mảng num[i]==num[j] mà i < j.
    // Ta có thể sử dụng hai vòng for lồng nhau để duyệt qua từng phần tử của mảng
    // Nếu hai giá trị bằng nhau thì tăng biến count lên 1
    // Rồi return về biến count

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}