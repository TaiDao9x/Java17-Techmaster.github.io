package leetcode;

import java.util.Stack;

public class _844_Backspace_String_Compare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
            } else {
                s1.add(c);
            }
        }
        for (Character c : t.toCharArray()) {
            if (c == '#') {
                if (!t1.isEmpty()) {
                    t1.pop();
                }
            } else {
                t1.add(c);
            }
        }
        return s1.equals(t1);
    }
}
