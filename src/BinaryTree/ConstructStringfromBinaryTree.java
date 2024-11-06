package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#606
 */
public class ConstructStringfromBinaryTree {
    public static void main(String[] args) {
        new ConstructStringfromBinaryTree().tree2str(new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3)));
    }
    public String tree2str(TreeNode root) {
        return tree2strUtil(root);
    }

    public String tree2strUtil(TreeNode root) {
        if(root==null) {
            return null;
        }
        String leftStr = tree2strUtil(root.left);
        String rightStr = tree2strUtil(root.right);
        String val =root.val+"";
        if(leftStr!=null) {
            val+="("+leftStr+")";
        }else if(leftStr==null && rightStr!=null) {
            val+="()";
        }
        if(rightStr!=null) {
            val+="("+rightStr+")";
        }
        return val;
    }
}
