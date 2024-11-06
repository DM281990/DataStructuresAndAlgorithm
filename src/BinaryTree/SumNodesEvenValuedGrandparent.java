package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#1315
 */
public class SumNodesEvenValuedGrandparent {
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        sumEvenGrandparentUtil(root);
        return sum;
    }

    private void sumEvenGrandparentUtil(TreeNode root) {
        if(root ==null)return;
        if(root.val%2==0){
            if(root.left!=null) {
                if (root.left.left != null) sum += root.left.left.val;
                if (root.left.right != null) sum += root.left.right.val;
            }
            if(root.right!=null){
                if(root.right.left!=null)sum+=root.right.left.val;
                if(root.right.right!=null)sum+=root.right.right.val;
            }
        }
        sumEvenGrandparentUtil(root.left);
        sumEvenGrandparentUtil(root.right);
    }
}
