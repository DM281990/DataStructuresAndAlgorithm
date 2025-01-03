package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#814
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if(root ==null) return null;
        root.left = pruneTree(root.left);
        root.right =pruneTree(root.right);
        if(root.val!=1 && root.left==null && root.right==null) return null;
        return root;
    }
}
