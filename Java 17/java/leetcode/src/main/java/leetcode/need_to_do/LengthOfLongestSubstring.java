package leetcode.need_to_do;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbe";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> rs = new HashSet<>();
        int max = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            if (!rs.contains(s.charAt(right))) {
                rs.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            } else {
                rs.remove(s.charAt(left));
                left++;
            }
        }
        return max;
    }

}
