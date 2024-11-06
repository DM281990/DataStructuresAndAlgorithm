package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode#1110
 */
public class DeleteNodesAndReturnForest {
    List<TreeNode> res;

    private TreeNode solve(TreeNode root, boolean is_root, Set<Integer> set) {
        // edge
        if (root == null) {
            return null;
        }

        boolean del = set.contains(root.val);
        if (is_root && !del) {
            res.add(root);
        }
        root.left = solve(root.left, del, set);
        root.right = solve(root.right, del, set);
        return del ? null : root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int td : to_delete) {
            set.add(td);
        }

        res = new ArrayList<>();
        solve(root, true, set);
        return res;
    }
}
