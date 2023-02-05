package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class _1859_Sorting_the_Sentence {

    // Cách 1
    public static String sortSentence(String s) {
        String[] a = s.split(" ");
        Map<Integer, String> map = new TreeMap<>();
        for (String value : a) {
            map.put(Integer.parseInt(value.substring(value.length() - 1)),
                    value.substring(0, value.length() - 1));
        }
        System.out.println(map);
        for (int i = 0; i < a.length; i++) {
            a[i] = map.get(i + 1);
        }
        return String.join(" ", a);
    }

    // Cách 2
    public static String sortSentence2(String s) {
        String[] sArray = s.split(" ");
        Arrays.sort(sArray, Comparator.comparingInt(o -> o.charAt(o.length() - 1)));
        for (int i = 0; i < sArray.length; i++) {
            sArray[i] = sArray[i].substring(0, sArray[i].length() - 1);
        }

        return String.join(" ", sArray);
    }

    public static void main(String[] args) {
        System.out.println( sortSentence("is2 sentence4 This1 a3"));
    }
}
