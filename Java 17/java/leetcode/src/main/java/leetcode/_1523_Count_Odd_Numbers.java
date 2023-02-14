package leetcode;

public class _1523_Count_Odd_Numbers {
    public int countOdds(int low, int high) {
        if (low % 2 != 0 || high % 2 != 0) {
            return ((high - low) / 2)+1;
        }
        return (high - low) / 2;
    }
}
