import java.util.Arrays;

public class FinalTest {

    // 1748. Sum of Unique Elements
    public int sumOfUnique(int[] nums) {
        int rs = 0;
        int n = nums.length;
        Arrays.sort(nums);
        if (n <= 1) return nums[0];
        if (nums[0] != nums[1]) {
            rs += nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            rs += nums[n - 1];
        }
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                rs += nums[i];
            }
        }
        return rs;
    }

    // 844. Backspace String Compare
    public static boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (i > 0 && s1.length() > 0) {
                    s1.deleteCharAt(s1.length() - 1);
                }
            } else {
                s1.append(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (i > 0 && t1.length() > 0) {
                    t1.deleteCharAt(t1.length() - 1);
                }
            } else {
                t1.append(t.charAt(i));
            }
        }
        return s1.toString().equals(t1.toString());
    }


    //100. Same Tree
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 733. Flood Fill
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];

        DFS(image, sr, sc, oldColor, color);

        return image;
    }

    private boolean isNotValid(int[][] image, int sr, int sc, int oldColor, int color) {
        return sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length

                || image[sr][sc] != oldColor || image[sr][sc] == color;

    }

    private void DFS(int[][] image, int sr, int sc, int oldColor, int color) {
        if (isNotValid(image, sr, sc, oldColor, color)) {
            return;
        }
        image[sr][sc] = color;
        DFS(image, sr - 1, sc, oldColor, color);
        DFS(image, sr + 1, sc, oldColor, color);
        DFS(image, sr, sc - 1, oldColor, color);
        DFS(image, sr, sc + 1, oldColor, color);
    }

    // 160. Intersection of Two Linked Lists

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int lenA = length(headA);

        int lenB = length(headB);


        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int length(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    // 1926. Nearest Exit from Entrance in Maze`
}