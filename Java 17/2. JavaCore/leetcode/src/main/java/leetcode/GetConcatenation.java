package leetcode;

public class GetConcatenation {
    public static void main(String[] args) {

    }

    public int[] getConcatenation(int[] nums) {
        int[] numsX2 = new int[nums.length * 2];
        System.arraycopy(nums, 0, numsX2, 0, nums.length);
        System.arraycopy(nums, 0, numsX2, nums.length, nums.length);
        return numsX2;
    }
}
