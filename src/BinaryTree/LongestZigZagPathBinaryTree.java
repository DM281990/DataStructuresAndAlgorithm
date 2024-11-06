package BinaryTree;

import util.TreeNode;

public class LongestZigZagPathBinaryTree {
    int count=0;
    public int longestZigZag(TreeNode root) {
        longestZigZagUtil(root.left,1,true);
        longestZigZagUtil(root.right,1,false);
        return count;
    }

    private void longestZigZagUtil(TreeNode root, int cnt, boolean left) {
        if(root==null)return;
        count=Math.max(count,cnt);
        if(left){
            longestZigZagUtil(root.left,1, true);
            longestZigZagUtil(root.right,cnt+1, false);
        }
        if(!left){
            longestZigZagUtil(root.right,1, false);
            longestZigZagUtil(root.left,cnt+1, true);
        }
    }
}
