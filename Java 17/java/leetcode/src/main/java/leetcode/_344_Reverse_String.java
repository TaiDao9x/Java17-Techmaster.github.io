package leetcode;

//s = ["h","e","l","l","o"]
public class _344_Reverse_String {
    public static void reverseString(char[] s) {
        int n = s.length;

        for (int i = 0; i < n / 2; i++) {
            char middle = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = middle;
        }

        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o' };
        reverseString(s);
    }
}
