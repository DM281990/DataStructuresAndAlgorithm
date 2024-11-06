package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#1325
 */
public class DeleteLeavesGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)return null;
        if(root.left ==null && root.right==null && root.val==target) return null;
        root.left=removeLeafNodes(root.left,target);
        root.right=removeLeafNodes(root.right,target);
        if(root.left ==null && root.right==null && root.val==target) return null;
        return root;
    }
}
