package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#2415
 */
public class ReverseOddLevelsBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevelsUtil(root.left,root.right,1);
        return root;
    }

    public void reverseOddLevelsUtil(TreeNode root1,TreeNode root2, int level){
        //condition possible as it is perfect binary tree
        if(root1 ==null|| root2==null) {
            return;
        }
        if(level%2!=0) {
            int teemp =root1.val;
            root1.val=root2.val;
            root2.val=teemp;
        }
        reverseOddLevelsUtil(root1.left,root2.right,level+1);
        reverseOddLevelsUtil(root1.right,root2.left,level+1);

    }}
