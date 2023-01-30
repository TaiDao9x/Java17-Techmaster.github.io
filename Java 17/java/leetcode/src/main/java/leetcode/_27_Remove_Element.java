package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _27_Remove_Element {

    public static int removeElement1(int[] nums, int val) {
        Integer[] nums2 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        List<Integer> list = new ArrayList<>(List.of(nums2));
        list.removeIf(n -> n == val);
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return list.size();
    }

    public static int removeElement2(int[] a, int val) {
        int n = a.length;

        for (int i = 0; i < n; ) {
            if (a[i] == val) {
                for (int j = i; j < n - 1; j++) {
                    a[j] = a[j + 1];

                }
                n--;
            } else {
                i++;
            }
        }

        return n;
    }

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
