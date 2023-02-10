package leetcode;

public class _374_Guess_Number_Higher_or_Lower {

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */

    public static int guess(int num) {
        int pick = 6;
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        }
        return 0;
    }

    // Theo đề bài thì sẽ luôn tồn tại kết quả là một số nằm trong khoảng [1,...,n]
    public static int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) { // Bằng 0 thì số đoán bằng số bốc
                return mid;
            } else if (guess(mid) == -1) { // bằng -1 thì số ta đoán lowns hơn số bốc được -> thu right lại để xét tiếp
                right = mid - 1;
            } else {
                left = mid + 1; // Ngược lại =1 thí số ta đoán nhỏ hơn số bốc -> thu left lại để xét tiếp
            }
        }
        return left; // left=right, break vòng while kết quả là right hoặc left vì luôn tồn tại 1 kết quả
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
