package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * Leetcode#513
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        return levelOrder(root);
    }
    public Integer levelOrder(TreeNode root) {
        TreeMap<Integer, Integer> levelMap = new TreeMap<>(Collections.reverseOrder());
        levelOrderUtil(root,levelMap,0);
        return levelMap.firstEntry().getValue();
    }

    private void levelOrderUtil(TreeNode root, TreeMap<Integer, Integer> levelMap, int level) {
        if(root ==null) return;
        levelOrderUtil(root.left,levelMap,level+1);
        if(!levelMap.containsKey(level))levelMap.put(level,root.val);
        levelOrderUtil(root.right,levelMap,level+1);
    }
}
