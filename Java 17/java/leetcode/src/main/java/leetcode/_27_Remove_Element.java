package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    public static int remove(int[] a, int val) {
        a = Arrays.stream(a).filter(n -> n != val).toArray();
          System.out.println(Arrays.toString(a));
        return a.length;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
//        System.out.println(removeElement(nums, 2));

        System.out.println(remove(nums, 3));
        System.out.println("Done");
    }
}
