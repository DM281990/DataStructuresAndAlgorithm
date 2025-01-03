package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#235
 */
public class LowestCommonAncestorBst {
    /**
     * Leetcode#235,236
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null) return null;
        if(root.val == p.val || root.val ==q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        else if(right ==null) return  left;
        return root;
    }
}
