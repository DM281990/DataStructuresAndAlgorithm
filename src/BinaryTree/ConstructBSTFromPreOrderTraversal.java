package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#1008
 * failed
 */
public class ConstructBSTFromPreOrderTraversal {
    int pIndex=0;
    public static void main(String[] args) {
        TreeNode root = new ConstructBSTFromPreOrderTraversal().bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder,0,1001);
    }

    public TreeNode bstFromPreorderUtil(int[] preorder ,int start,int end) {
        if(pIndex>=preorder.length) return null;
        if(preorder[pIndex]<start || preorder[pIndex]>end) return new TreeNode(pIndex);
        TreeNode node = new TreeNode(pIndex);
        return node;
    }
}
