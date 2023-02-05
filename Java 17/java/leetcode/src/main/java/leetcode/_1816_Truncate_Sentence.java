package leetcode;

import java.util.Arrays;

//s = "Hello how are you Contestant", k = 4
public class _1816_Truncate_Sentence {
    public static String truncateSentence(String s, int k) {
        String[] sentence = s.split(" ");
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            rs.append(sentence[i])
                    .append(" ");
        }
        rs.append(sentence[k - 1]);

        return rs.toString();
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        System.out.println(truncateSentence(s, 4));
    }
}
