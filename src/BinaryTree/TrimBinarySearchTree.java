package BinaryTree;

import util.TreeNode;

/**
 * Leetcode687,669
 */
public class TrimBinarySearchTree {
    public static void main(String[] args) {
        new TrimBinarySearchTree().trimBST(new TreeNode(1,new TreeNode(0,null,null),new TreeNode(2,null,null)),1,2);
    }
    public TreeNode trimBST(TreeNode node, int low, int high) {
        if(node == null)
            return null;
        node.left = trimBST(node.left, low, high);
        node.right = trimBST(node.right, low, high);
        if(node.val > high || node.val < low){
            if(node.left != null)
                return node.left;
            else
                return node.right;
        }
        else return node;
    }
}
