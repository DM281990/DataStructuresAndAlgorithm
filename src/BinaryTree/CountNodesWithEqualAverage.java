package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#2265
 */
public class CountNodesWithEqualAverage {
    int cnt=0;
    public int averageOfSubtree(TreeNode root) {
        averageOfSubtreeUtil(root);
        return cnt;
    }
    public  int[]  averageOfSubtreeUtil(TreeNode root) {
        if(root == null)return new int[] {0,0};
        int []leftSubTree = averageOfSubtreeUtil(root.left);
        int []rightSubTree = averageOfSubtreeUtil(root.right);
        int []tree = new int[] {root.val,1};
        tree[0] +=leftSubTree[0]+rightSubTree[0];
        tree[1] +=leftSubTree[1]+rightSubTree[1];
        if(tree[0]/tree[1]==root.val) {
            cnt++;
        }
        return tree;
    }
}
