package day12_tree.classroom;

public class _98_Validate_Binary_Search_Tree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        // So sánh giá trị min, max với giá trị của root
        if (root.left != null && findMaxLeft(root.left) > root.val) return false;
        if (root.right != null && findMInRight(root.right) < root.val) return false;
        if (!isValidBST(root.left) || !isValidBST(root.right)) return false;
        return true;
    }

    // Tìm giá trị nhỏ nhất của subtree bên phải
    public int findMInRight(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    // Tìm giá trị lớn nhất của subtree bên trái
    public int findMaxLeft(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }
}
