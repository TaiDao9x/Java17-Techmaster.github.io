package leetcode;

public class FinalValueAfterOperations {
    public static void main(String[] args) {
        String[] str = {"++X", "++X", "X++"};
        System.out.println(finalValueAfterOperations(str));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int[] number = new int[operations.length];
        int rs = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("++X") || operations[i].equals("X++")) {
                number[i] = 1;
            } else {
                number[i] = -1;
            }
        }
        for (int i : number) {
            rs = rs + i;
        }
        return rs;
    }
}
