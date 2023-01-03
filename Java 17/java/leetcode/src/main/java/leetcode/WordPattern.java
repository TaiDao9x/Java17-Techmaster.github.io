package leetcode;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat do";

        System.out.println(wordPattern(pattern, s));

    }

    public static boolean wordPattern(String pattern, String s) {
        String[] a = s.split(" ");
        String[] b = pattern.split("");
        boolean rs = true;
        if (a.length == b.length) {
            for (int i = 0; i < pattern.length() - 1; i++) {
                for (int j = i + 1; j < pattern.length(); j++) {
                    rs = rs && (a[i].equals(a[j]) == b[i].equals(b[j]));
                }
            }
        } else rs = false;

        return rs;
    }
}
