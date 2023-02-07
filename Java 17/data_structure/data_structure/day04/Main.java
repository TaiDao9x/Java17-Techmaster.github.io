package day04;

public class Main {

    public static int sum2(int[] a, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return a[endIndex];
        }
        return a[startIndex] + sum2(a, startIndex + 1, endIndex);
    }

    public static void travel(int[][] a, int i, int j) {
        if (i == a.length - 1 && j == a[i].length - 1) {
            System.out.print(a[i - 1][j - 1]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sum2(a, 1, 4));
    }
}
