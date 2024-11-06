package BinaryTree;

import util.TreeNode;

import javax.swing.*;

/**
 * Leetcode#687
 */
public class LongestUnivaluePAth {
    public static void main(String[] args) {
        new LongestUnivaluePAth().longestUnivaluePath(
                new TreeNode(1,
                        new TreeNode(4, new TreeNode(4), new TreeNode(4)), new TreeNode(5, null, new TreeNode(5)))
        );
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int max[] = new int[1];
        longestUnivaluePathUtil(root, max, 0, root.val);
        return max[0];
    }

    private int longestUnivaluePathUtil(TreeNode root, int[] max, int index, int paraent) {
        if (root == null) {
            return index;
        }
        int left = longestUnivaluePathUtil(root.left, max, index, root.val);
        int right = longestUnivaluePathUtil(root.right, max, index, root.val);
        max[0]=Math.max(max[0],left+right);
        if(root.val==paraent) {
            return 1+Math.max(left, right);
        }
        return 0;
    }
}
