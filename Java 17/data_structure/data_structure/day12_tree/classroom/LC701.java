package day12_tree.classroom;

public class LC701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if (root == null) {
            root = newNode;
            return root;
        }
        // root !=null
        // tim vi tri de add newnode vao

        TreeNode current = root;
        while (true) {
            // neu val > root -> xet subtree ben phai
            if (val > current.val) {
                if (current.right == null) {
                    current.right = newNode;
                    break;
                } else {
                    // dich chuyen xuong subtree ben phai
                    current = current.right;
                }
            } else {
                // xet subtree ben trai
                if (current.left == null) {
                    current.left = newNode;
                    break;
                } else {
                    // dich chuyen xuong subtree left de duyt
                    current = current.left;
                }
            }
        }
        return root;
    }
}
