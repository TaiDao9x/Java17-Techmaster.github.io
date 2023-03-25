package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();

        int maxCandi = 0;

        for (int i = 0; i < candies.length; i++) {
            if (maxCandi < candies[i]) {
                maxCandi = candies[i];
            }
        }
        for (int i = 0; i < candies.length; i++) {
            if (maxCandi <= candies[i] + extraCandies) {
                list.add(true);
            } else {
                list.add(false);
            }
        }
        return list;
    }
}
