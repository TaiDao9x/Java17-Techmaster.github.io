package day12_tree.classroom;

public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        // root != null
        // tim node can xoa
        if (key < root.val) {
            // xet bai toan con subtree been trai
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // xet bai toan con subtree ben phai
            root.right = deleteNode(root.right, key);

            // gia su root.right la 1 nut leaf va root.right.val==key
            // deleteNode(root.right, key) = null
        } else {
            // key == root.val
            if (root.left == null && root.right == null) {
                // nut leaf
                return null;
            }

            // co 1 con
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // co 2 con
            int temp = findMinOfRightSubtree(root.right);
            root.val = temp;
            root.right = deleteNode(root.right, temp);
        }
        return root;
    }

    private static int findMinOfRightSubtree(TreeNode root) {
        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr.val;
    }
}
