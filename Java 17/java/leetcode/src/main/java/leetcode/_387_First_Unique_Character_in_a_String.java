package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _387_First_Unique_Character_in_a_String {
    public static int firstUniqChar(String s) {
        List<Character> list = new ArrayList<>();
        List<Character> toRemove = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    toRemove.add(s.charAt(i));
                }
            }
        }
        list.removeAll(toRemove);
        if (list.size() > 0) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == list.get(0)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
