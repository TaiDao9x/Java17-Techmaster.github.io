package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _2418_Sort_the_People {

    // PHÂN TÍCH ĐỀ BÀI:
    // Sử dụng 2 vòng for để kiểm tra và sắp xếp
    // Sau khi sắp xếp xong chiều cao -> ta dựa vào các chỉ số vừa thay đổi để sắp xếp lại tên


    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;

        // Sử dụng vòng for để sắp xếp
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (heights[i] < heights[j]) {
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;

                    String swap = names[i];
                    names[i] = names[j];
                    names[j] = swap;

                }
            }
        }
        return names;
    }

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma"};
        int[] heights = {180, 165, 170};

        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }

}
