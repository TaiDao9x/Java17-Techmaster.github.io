package leetcode;

public class _278_First_Bad_Version {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    private static boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) { // Nếu true => mid là 1 version fail, nhưng chưa chắc là version đầu tiên
                right = mid;         // Chuyển bằng right để tiếp tục tìm version lỗi đầu tiên
            } else {
                left = mid + 1; // False => mid là version chuẩn, chuyển thành left để tìm tiếp version lỗi
            }
        }
        // khi left=right (chỉ còn 1 version)=> break vòng while chính là vị trí version lỗi đầu tiên
        return right; // có thể trả về left hoặc right đều đúng
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }
}
