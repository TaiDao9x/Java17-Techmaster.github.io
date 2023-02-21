package leetcode;

public class _67_Add_Binary {
    public static String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();

        char[] c = new char[m];
        for (int i = 0; i < m; i++) {
            c[i] = a.charAt(i);
        }
        char[] d = new char[n];
        for (int i = 0; i < n; i++) {
            d[i] = b.charAt(i);
        }

        int right1 = m - 1;
        int right2 = n - 1;

        while (right2 >= 0 || right1 >= 0) {

        }
        return "a";
    }


    public static void main(String[] args) {
        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        System.out.println(addBinary(a, b));
    }
}
