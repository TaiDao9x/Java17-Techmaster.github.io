package leetcode;

public class _367_Valid_Perfect_Square {

    // PHÂN TÍCH ĐỀ BÀI
    // Ta sử dụng binary search để tìm ra số mà nhân với chính nó bằng num
    // sử dụng kiểu dữ liệu long để tránh tràn số do có thể num = Max
    // Sử dụng 2 biến left và right để thu hẹp dãy số cần kiểm tra
    public static boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {

            // Mid là số ở giữa
            long mid = (left + right) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) { // mid bé quá nên ta tìm trong dãy số bên phải của mid
                left = mid + 1;
            } else {
                right = mid - 1; // mid to quá nên ta tìm số mid trong dãy nhỏ hơn mid
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
