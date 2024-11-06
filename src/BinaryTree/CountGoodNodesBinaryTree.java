package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#1448
 */
public class CountGoodNodesBinaryTree {
    int count =0;
    public int goodNodes(TreeNode root) {
        goodNodesUtil(root,Integer.MIN_VALUE);
        return count;
    }

    private void goodNodesUtil(TreeNode root, int max) {
        if(root ==null)return;
        if(root.val>=max){
            count++;
            max= root.val;
        }
        goodNodesUtil(root.left,max);
        goodNodesUtil(root.right,max);
    }
}
