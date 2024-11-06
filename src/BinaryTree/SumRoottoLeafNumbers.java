package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#129
 */
public class SumRoottoLeafNumbers {
    int count =0;
    public int sumNumbers(TreeNode root) {
        sumNumbersUtil(root,0);
        return count;
    }
    public void sumNumbersUtil(TreeNode root,int result) {
        if(root ==null) return;
        if(root.left==null && root.right==null){
            count+=result*10+root.val;
            return;
        }
        sumNumbersUtil(root.left,result*10+root.val);
        sumNumbersUtil(root.right,result*10+root.val);

    }
}
