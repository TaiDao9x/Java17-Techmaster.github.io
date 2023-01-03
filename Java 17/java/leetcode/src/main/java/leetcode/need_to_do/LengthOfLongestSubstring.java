package leetcode.need_to_do;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s));

        ArrayList<Integer> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    break;
                }else {
                    count++;
                }
                list.add(count);
            }
        }
        System.out.println(list);
    }

    public static int lengthOfLongestSubstring(String s) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    count++;
                    if (count > max) {
                        max = count + 1;
                    }
                } else {
                    count = 0;

                }
                list.add(count);
            }
        }
        return max;
    }
}
