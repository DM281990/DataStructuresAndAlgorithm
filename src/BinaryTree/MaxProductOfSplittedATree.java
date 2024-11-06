package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode#1339
 */
public class MaxProductOfSplittedATree {
    public static void main(String[] args) {
        new MaxProductOfSplittedATree().maxProduct(
                new TreeNode(1, new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),null))
        );
    }
    int mod = 1000000007;
    long max = 0;
    long total;
    public int maxProduct(TreeNode root) {
        this.total = dfs(root);
        traverse(root);
        return (int)(max%mod);
    }

    private int dfs(TreeNode root)
    {
        if(root==null)
            return 0;
        return root.val += dfs(root.left) + dfs(root.right);
    }

    private void traverse(TreeNode root)
    {
        if(root==null)
            return;
        max = Math.max(root.val*(total-root.val),max);
        traverse(root.left);
        traverse(root.right);
    }
}
