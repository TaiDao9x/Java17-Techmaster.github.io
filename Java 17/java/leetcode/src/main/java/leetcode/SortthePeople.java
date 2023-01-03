package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SortthePeople {
    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};
        System.out.println(Arrays.toString(sortPeople(names, heights)));

    }

    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new TreeMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        List<String> list = new ArrayList<>();
        Set<Integer> set = map.keySet();
        for (Integer k : set) {
            list.add(map.get(k));
        }

        list.toArray(names);
        for (int i = 0; i < names.length/2; i++) {
            String temp = names[i];
            names[i] = names[names.length - 1 - i];
            names[names.length - 1 - i] = temp;
        }
        return names;
    }
}
