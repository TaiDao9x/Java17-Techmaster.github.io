package leetcode;

public class _567_Permutation_in_String {
    public static boolean checkInclusion(String s1, String s2) {
        StringBuilder check = new StringBuilder();
        for (int i = s1.length() - 1; i >= 0; i--) {
            check.append(s1.charAt(i));
        }
        return s2.contains(check) || s2.contains(s1);
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
