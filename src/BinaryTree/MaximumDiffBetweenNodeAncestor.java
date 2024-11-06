package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#1026
 */
public class MaximumDiffBetweenNodeAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiffUtil(root,root.val,root.val);
    }
    public int maxAncestorDiffUtil(TreeNode root,int max , int min){
        if(root ==null) return 0;
        min = Math.min(min,root.val);max = Math.max(max,root.val);
        if(root.left ==null && root.right==null)return (max-min);
        int left = maxAncestorDiffUtil(root.left, max,min);
        int right = maxAncestorDiffUtil(root.right, max,min);
        return Math.max(right,left);
    }
}
