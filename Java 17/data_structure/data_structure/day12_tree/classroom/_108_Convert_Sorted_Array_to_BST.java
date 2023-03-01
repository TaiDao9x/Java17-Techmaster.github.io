package day12_tree.classroom;

public class _108_Convert_Sorted_Array_to_BST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        return insertNode(0, nums.length, nums);
    }

    public static TreeNode insertNode(int x, int y, int[] nums) {

        // x>=y -> node left -> return null
        if (x >= y) return null;

        // Because it's height-balance BST -> every node is nums[mid]
        int mid = (x + y) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        // root.left is nums[mid] of left side
        root.left = insertNode(x, mid, nums);

        // root.right is nums[mid] of right side
        root.right = insertNode(mid + 1, y, nums);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        System.out.println(nums.length);
        sortedArrayToBST(nums);
        System.out.println(sortedArrayToBST(nums));
        System.out.println("Done");
    }
}
