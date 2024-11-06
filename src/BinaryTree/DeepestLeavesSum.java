package BinaryTree;

import util.TreeNode;

import java.util.Collections;
import java.util.TreeMap;

/**
 * Leetcode#1302
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());
        deepestLeavesSumUtil(root,map,0);
        return map.firstEntry().getValue();
    }

    private void deepestLeavesSumUtil(TreeNode root, TreeMap<Integer, Integer> map,int level) {
        if(root==null)return;
        map.computeIfPresent(level,(k,v)->v+root.val);
        map.computeIfAbsent(level,k->root.val);
        deepestLeavesSumUtil(root.left,map,level+1);
        deepestLeavesSumUtil(root.right,map,level+1);
    }
}
