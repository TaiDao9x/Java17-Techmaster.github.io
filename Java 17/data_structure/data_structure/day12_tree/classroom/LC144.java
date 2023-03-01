package day12_tree.classroom;

import java.util.LinkedList;
import java.util.List;

public class LC144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rs = new LinkedList<>();

        preoder(root, rs);
        return rs;
    }

    private void preoder(TreeNode root, List<Integer> rs) {
        if (root == null) return;
        // process current node
        rs.add(root.val);

        // left subtree
        preoder(root.left, rs);

        // right subtree
        preoder(root.right, rs);
    }
}
