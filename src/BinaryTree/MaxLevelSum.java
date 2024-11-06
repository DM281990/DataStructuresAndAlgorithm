package BinaryTree;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode#1161
 */
public class MaxLevelSum {
    public static void main(String[] args) {
    }
    public int maxLevelSum(TreeNode root) {
        Map<Integer,Integer> levelSumMap = new HashMap<>();
        maxLevelSumUtil(root,levelSumMap,1);
        int maxsum=Integer.MIN_VALUE;
        int level =0;
        for(Integer key:levelSumMap.keySet()) {
            if(levelSumMap.get(key)>maxsum) {
                level=key;
                maxsum = levelSumMap.get(key);
            }
        }
        return level;
    }

    private void maxLevelSumUtil(TreeNode root, Map<Integer, Integer> levelSumMap,int level) {
        if(root==null) {
            return;
        }
        if(levelSumMap.containsKey(level)) {
            int val=levelSumMap.get(level);
            val+=root.val;
            levelSumMap.put(level, val);
        }
        else {
            levelSumMap.put(level, root.val);
        }
        maxLevelSumUtil(root.left,levelSumMap,level+1);
        maxLevelSumUtil(root.right,levelSumMap,level+1);
    }
}
