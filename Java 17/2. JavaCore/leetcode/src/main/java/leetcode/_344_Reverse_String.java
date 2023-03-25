package leetcode;

//s = ["h","e","l","l","o"]
public class _344_Reverse_String {

    public static void reverseString(char[] s) {
        reverseStringUseRecursion(s, 0, s.length - 1);
    }

    public static void reverseStringUseRecursion(char[] s, int a, int b) {
        if (a > b) {
            return;
        }
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
        reverseStringUseRecursion(s, a + 1, b - 1);

    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseStringUseRecursion(s, 0, s.length - 1);
    }
}
