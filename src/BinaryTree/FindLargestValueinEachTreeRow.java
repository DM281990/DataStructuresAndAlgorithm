package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Leecode#515
 */
public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        return levelOrder(root);
    }

    public List<Integer> levelOrder(TreeNode root) {
        TreeMap<Integer, Integer> levelMap = new TreeMap<>();
        levelOrderUtil(root,levelMap,0);
        return new ArrayList<>(levelMap.values());
    }

    private void levelOrderUtil(TreeNode root, TreeMap<Integer, Integer> levelMap, int level) {
        if(root ==null) return;
        levelOrderUtil(root.left,levelMap,level+1);
        if(!levelMap.containsKey(level)|| levelMap.get(level)<root.val)levelMap.put(level,root.val);
        levelOrderUtil(root.right,levelMap,level+1);
    }
}
