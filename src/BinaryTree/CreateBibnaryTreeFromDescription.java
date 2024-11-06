package BinaryTree;

import util.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode#2196
 */
public class CreateBibnaryTreeFromDescription {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> parentSet = new HashSet<>();
        Set<Integer> childSet = new HashSet<>();

        for (int i = 0; i < descriptions.length; i++) {
            int[] description = descriptions[i];
            TreeNode parent = null;
            TreeNode child = null;
            if (nodeMap.containsKey(description[0])) {
                parent = nodeMap.get(description[0]);
            } else {
                parent = new TreeNode(description[0]);
                nodeMap.put(description[0], parent);
            }
            if (nodeMap.containsKey(description[1])) {
                child = nodeMap.get(description[1]);
            } else {
                child = new TreeNode(description[1]);
                nodeMap.put(description[1], child);
            }
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            parentSet.add(description[0]);
            childSet.add(description[1]);
        }
        TreeNode root =null;
        parentSet.removeAll(childSet);
        for (Integer s : parentSet) {
            root= nodeMap.get(s);
        }
        return root;
    }
}
