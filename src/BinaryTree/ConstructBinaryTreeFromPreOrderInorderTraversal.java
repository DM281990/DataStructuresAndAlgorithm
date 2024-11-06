package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#105
 */
public class ConstructBinaryTreeFromPreOrderInorderTraversal {
    public static void main(String[] args) {

        new ConstructBinaryTreeFromPreOrderInorderTraversal().buildTree(new int[]{3,9,20,15,7},
                new int[]{9,3,15,20,7});
    }
    private int i = 0;
    private int p = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode node = buildUtil(preorder, inorder, 0,inorder.length-1,0);
        return node;
    }

    private TreeNode buildUtil(int[] preorder, int[] inorder, int start, int end,int rootNodePos) {
        if(start>end || rootNodePos>=preorder.length) return null;
        int rootval = preorder[rootNodePos];
        int i =start;
        for(;i<=end;i++){
            if(inorder[i]==rootval){
                break;
            }
        }
        if(i>end){
            return null;
        }

            rootNodePos++;
        return new TreeNode(rootval,buildUtil(preorder, inorder, start,i-1,rootNodePos),
                buildUtil(preorder, inorder, i+1,end,rootNodePos));
    }


}
