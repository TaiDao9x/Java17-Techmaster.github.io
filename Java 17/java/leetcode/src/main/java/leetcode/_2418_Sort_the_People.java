package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _2418_Sort_the_People {

    // PHÂN TÍCH ĐỀ BÀI:

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Sử dụng mảng làm trung gian để chuyển vị trí bên mảng name
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Sắp xếp mảng index theo sự sắp xếp của mảng height
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return heights[o2] - heights[o1];
            }
        });

        String[] rs = new String[n];

        // Dựa vào mảng index để thêm vào mảng rs như mong muốn
        for (int i = 0; i < n; i++) {
            rs[i] = names[index[i]];
        }
        return rs;
    }

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }

}
