package leetcode;

import java.util.HashSet;

public class _771_Jewels_and_Stones {

    // Answer1: O(n)
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> map = new HashSet<>();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            map.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (map.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    // Answer 2: O(n^2 )
    public int numJewelsInStones2(String jewels, String stones) {
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
