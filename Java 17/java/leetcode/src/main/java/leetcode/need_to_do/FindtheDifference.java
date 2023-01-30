package leetcode.need_to_do;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindtheDifference {

    public static void main(String[] args) {
        findTheDifference("a","aa");
    }
    public static void findTheDifference(String s, String t) {

        List<String> toRemove = new ArrayList<>(Arrays.asList(s.split("")));
        List<String> list = new ArrayList<>(Arrays.asList(t.split("")));
        list.removeAll(toRemove);
        String rs = list.get(0);
        System.out.println(toRemove);
        System.out.println(list);
        System.out.println(rs);
        System.out.println(rs.charAt(0));
//        return rs.charAt(0);
    }
}
