package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#988
 */
public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
        new SmallestStringStartingFromLeaf().smallestFromLeaf(
                new TreeNode(0,new TreeNode(1,new TreeNode(3),new TreeNode(4)),new TreeNode(2,new TreeNode(3),new TreeNode(4)))
        );
    }
    String s="";
    public String smallestFromLeaf(TreeNode root) {
        smallestFromLeafUtil(root,"");
        return s;
    }

    private void smallestFromLeafUtil(TreeNode root, String str) {
        if(root==null)return;
        if(root.left==null &&root.right==null){
            str = ((char)(root.val+97)) +str;
            if(!s.equals("")) s=str.compareTo(s)<0?str:s;
            else s=str;
            return;
        }
        smallestFromLeafUtil(root.left,((char)(root.val+97))+str);
        smallestFromLeafUtil(root.right,((char)(root.val+97))+str);
    }
}
