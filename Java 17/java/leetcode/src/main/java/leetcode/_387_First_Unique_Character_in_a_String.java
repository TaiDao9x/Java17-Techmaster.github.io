package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _387_First_Unique_Character_in_a_String {

    // Use Hashset  O(n)
    public static int firstUniqChar(String s) {
        Set<Character> setUnique = new HashSet<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                if (setUnique.contains(s.charAt(i))) {
                    setUnique.remove(s.charAt(i));
                    set.add(s.charAt(i));
                } else setUnique.add(s.charAt(i));
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (setUnique.contains(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }


    public static int firstUniqChar2(String s) {
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

    public static int firstUniqChar1(String s) {
        int minIndex = Integer.MAX_VALUE;
        for (int c = 'a'; c < 'z'; c++) {
            int indexInS = s.indexOf(c);
            if (indexInS != -1 && indexInS == s.lastIndexOf(c)) {
                minIndex = Math.min(minIndex, indexInS);
            }
        }
        if (minIndex == Integer.MAX_VALUE) {
            return -1;
        }
        return minIndex;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }
}
