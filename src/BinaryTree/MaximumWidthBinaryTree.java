package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode#662
 */
public class MaximumWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        widthOfBinaryTreeUtil(root, 1, levelMap, 0);
        int max=0;
        for(Integer i:levelMap.keySet()) {
            List<Integer> list =levelMap.get(i);
            max =Math.max(max, 1+list.get(list.size()-1)-list.get(0));
        }
        return max;
    }
    private void widthOfBinaryTreeUtil(TreeNode root, int index, Map<Integer, List<Integer>> levelMap, int level) {
        if (root == null) {
            return;
        }
        if (!levelMap.containsKey(level)) {
            List<Integer> list =new ArrayList<>();
            list.add(index);
            levelMap.put(level,list);
        } else {
            levelMap.get(level).add(index);
        }
        widthOfBinaryTreeUtil(root.left,2*index, levelMap, level + 1);
        widthOfBinaryTreeUtil(root.right, 2*index+1,levelMap, level + 1);
    }

}
