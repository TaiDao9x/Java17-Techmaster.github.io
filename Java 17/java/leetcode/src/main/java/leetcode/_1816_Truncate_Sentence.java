package leetcode;

import java.util.Arrays;

//s = "Hello how are you Contestant", k = 4
public class _1816_Truncate_Sentence {
    public static String truncateSentence(String s, int k) {
        String[] sentence = s.split(" ");
        s = String.join(" ", Arrays
                .stream(sentence)
                .limit(k)
                .toList());
        return s;
    }

    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        System.out.println(truncateSentence(s, 4));
    }
}
