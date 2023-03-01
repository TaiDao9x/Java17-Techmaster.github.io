package day12_tree.classroom;

public class Main {
    public static void main(String[] args) {
        LC701 test = new LC701();
        TreeNode root = new TreeNode(5);
        root = test.insertIntoBST(root, 1);
        root = test.insertIntoBST(root, 7);
        root = test.insertIntoBST(root, 0);
        root = test.insertIntoBST(root, 3);
        root = test.insertIntoBST(root, 6);
        root = test.insertIntoBST(root, 8);

        preoder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println("Done");
    }

    private static void preoder(TreeNode root) {
        if (root == null) return;
        // process current node
        System.out.print(root.val + " ");

        // left subtree
        preoder(root.left);

        // right subtree
        preoder(root.right);

    }

    private static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.val + " ");
    }
}
