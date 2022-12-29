package leetcode;

public class MostWordsFound {
    public static void main(String[] args) {
        String[] str = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};

        System.out.println(mostWordsFound(str));

    }

    public static int mostWordsFound(String[] sentences) {
        int[] count = new int[sentences.length];
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            String[] words = sentences[i].split(" ");
            count[i] = words.length;
        }
        for (int num : count) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}