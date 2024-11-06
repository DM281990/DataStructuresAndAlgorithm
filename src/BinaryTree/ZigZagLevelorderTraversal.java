package BinaryTree;

import util.TreeNode;

import java.util.*;

/**
 * Leetcode#103
 */
public class ZigZagLevelorderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer, List<Integer>> levelOrderTraversalmap = new HashMap<>();
        zigZagOrderTraversalUtil(root, 1, levelOrderTraversalmap, false);
        List<List<Integer>> result = new ArrayList<>();
        int size = levelOrderTraversalmap.size();
        for (int i = 1; i <= size; i++) {
            result.add(levelOrderTraversalmap.get(i));
        }
        return result;
    }

    private void zigZagOrderTraversalUtil(TreeNode root, int level, Map<Integer, List<Integer>> levelOrderTraversalmap,
                                          boolean rightToLeft) {
        if (root == null) {
            return;
        }
        if (!levelOrderTraversalmap.containsKey(level)) {
            List<Integer> arrList = new ArrayList<>();
            arrList.add(root.val);
            levelOrderTraversalmap.put(level, arrList);
        } else {
            if(rightToLeft) {
                levelOrderTraversalmap.get(level).add(0, root.val);
            }
            else {
                levelOrderTraversalmap.get(level).add(root.val);
            }
        }
        zigZagOrderTraversalUtil(root.left, level + 1, levelOrderTraversalmap, !rightToLeft);
        zigZagOrderTraversalUtil(root.right, level + 1, levelOrderTraversalmap, !rightToLeft);

    }
}
