package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#701
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertIntoBSTUtil(root,val,root);
    }

    private TreeNode insertIntoBSTUtil(TreeNode root, int val, TreeNode parent) {
        if(root==null)return new TreeNode(val);
        if(val<root.val) root.left=insertIntoBSTUtil(root.left,val,root);
        if(val>root.val) root.right=insertIntoBSTUtil(root.right,val,root);
        return root;
    }
}
