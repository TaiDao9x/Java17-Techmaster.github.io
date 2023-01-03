package leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class SortingtheSentence {
    public static void main(String[] args) {
        String s = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s));
        String[] a = s.split(" ");
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(Integer.parseInt(a[i].substring(a[i].length() - 1)),
                    a[i].substring(0, a[i].length() - 1));
        }
        System.out.println(map);
        String[] b = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = map.get(i+1);
        }
        System.out.println(Arrays.toString(b));
    }

    public static String sortSentence(String s) {
        String[] a = s.split(" ");
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(Integer.parseInt(a[i].substring(a[i].length() - 1)),
                    a[i].substring(0, a[i].length() - 1));
        }

        String[] b = new String[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = map.get(i+1);
        }
        return String.join(" ", b);
    }
}
