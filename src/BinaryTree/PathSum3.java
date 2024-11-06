package BinaryTree;

import util.TreeNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode#437
 */
public class PathSum3 {
    int count =0;
    public int pathSum1(TreeNode root, int targetSum) {
        Set<Integer> integerSet = new HashSet<>();
        pathSumUtil(root,integerSet,targetSum,0,"");
        return count;
    }

    private void pathSumUtil(TreeNode root, Set<Integer> integerSet,int targetSum,int currSum,String path) {
        if(root==null)return;
        currSum+=root.val;
        integerSet.add(root.val);
        if(root.val==targetSum)count++;
        if(integerSet.contains(currSum-targetSum)||currSum-targetSum==0)count++;
        pathSumUtil(root.left,integerSet,targetSum,currSum,path+","+root.val);
        pathSumUtil(root.right,integerSet,targetSum,currSum,path+","+root.val);
        integerSet.remove(root.val);
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }
}
