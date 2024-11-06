package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Leetcode#107
 */
public class BottomUpLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        TreeMap<Integer, List<Integer>> levelMap = new TreeMap<>(Collections.reverseOrder());
        levelOrderUtil(root,levelMap,0);
        return new ArrayList<>(levelMap.values());
    }

    private void levelOrderUtil(TreeNode root, TreeMap<Integer, List<Integer>> levelMap, int level) {
        if(root ==null) return;
        levelOrderUtil(root.left,levelMap,level+1);
        if(!levelMap.containsKey(level))levelMap.put(level,new ArrayList<>());
        levelMap.get(level).add(root.val);
        levelOrderUtil(root.right,levelMap,level+1);
    }
}