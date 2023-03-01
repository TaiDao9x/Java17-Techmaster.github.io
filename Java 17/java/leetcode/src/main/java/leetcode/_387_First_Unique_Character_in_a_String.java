package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _387_First_Unique_Character_in_a_String {

    // Use Hashset  O(n)
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else map.put(c, 0);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 0) {
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
