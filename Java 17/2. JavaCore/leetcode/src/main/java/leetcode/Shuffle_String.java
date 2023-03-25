package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Shuffle_String {
    public static void main(String[] args) {
//        restoreString("codeleet",new int[]{4, 5, 6, 7, 0, 2, 1, 3});

    }
    public static String restoreString(String s, int[] indices) {
       Map<Integer,String> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(indices[i], String.valueOf(s.charAt(i)));
        }
        String[] rs=new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            rs[i]= map.get(i);
        }
        return String.join("",rs);
    }
}
