package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#98
 */
public class IsValidBst {

    public boolean isValidBST(TreeNode root) {
        if(root ==null)return true;
        return isValidBSTUtil(root.left,Long.MIN_VALUE,(long)root.val) &&
                isValidBSTUtil(root.right,(long)root.val,Long.MAX_VALUE);
    }

    private boolean isValidBSTUtil(TreeNode root, Long minValue, Long maxVal) {
        if(root ==null) return true;
        if(root.val>minValue && root.val<maxVal) return isValidBSTUtil(root.left,minValue,(long)root.val)&&isValidBSTUtil(root.right,(long)root.val,maxVal);
        return false;
    }
}
