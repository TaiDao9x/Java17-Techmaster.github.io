package leetcode;

public class _387_First_Unique_Character_in_a_String {
    public static int firstUniqChar(String s) {
        int[] alphabet = new int[30];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (alphabet[s.charAt(i) - 'a'] == 1) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "bacbcddee";
        System.out.println(firstUniqChar(s));
    }
}
