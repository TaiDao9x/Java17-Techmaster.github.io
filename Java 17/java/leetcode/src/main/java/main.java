import java.util.Arrays;

public class main {

    public int[] buildArray(int[] nums) {
        int length = nums.length;
        int[] rs = new int[length];

        for (int i = 0; i < length; i++) {
            rs[i] = nums[nums[i]];
        }
        return rs;
    }

    public static String restoreString(String s, int[] indices) {
        char[] str = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            str[indices[i]] = s.charAt(i);
        }
        return String.valueOf(str);
    }

    public static void main(String[] args) {
        int[] in = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString("codeleet", in));


    }
}
