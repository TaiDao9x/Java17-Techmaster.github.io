package leetcode;

import java.util.Arrays;

public class NumJewelsInStones {
    public static void main(String[] args) {
        System.out.println(numJewelsInStones("aA", "aAAbbbb"));
    }

    public static int numJewelsInStones(String jewels, String stones) {
        char[] jewelsArr = new char[jewels.length()];
        char[] stoneArr = new char[stones.length()];

        for (int i = 0; i < jewels.length(); i++) {
            jewelsArr[i] = jewels.charAt(i);
        }
        for (int i = 0; i < stones.length(); i++) {
            stoneArr[i] = stones.charAt(i);
        }
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewelsArr[i] == stoneArr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
