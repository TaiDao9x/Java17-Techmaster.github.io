package leetcode;


public class _27_Remove_Element {


    public static int removeElement(int[] a, int val) {
        int n = a.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != val) {
                a[k] = a[i];
                k++;
            }
        }
        return k;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
        System.out.println("DONE");
    }
}
