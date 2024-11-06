package BinaryTree;

import util.TreeNode;

import java.util.*;

/**
 * Leetcode#652
 */
public class FindDuplicaeSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,TreeNode> treeMpa = new HashMap<>();
        Map<String,Integer> countTreeMap = new HashMap<>();
        Set<TreeNode> treeSet = new HashSet<>();
        findDuplicateSubtreesUtil(root,treeMpa,countTreeMap,treeSet);
        List<TreeNode> treeList = new ArrayList<>(treeSet);
        return treeList;
    }

    private String findDuplicateSubtreesUtil(TreeNode root, Map<String, TreeNode> mapNode, Map<String, Integer> countTreeMap, Set<TreeNode> treeSet) {
        if(root ==null) {
            return "$";
        }
        String leftSubTree = findDuplicateSubtreesUtil(root.left,mapNode,countTreeMap,treeSet);
        String rightSubTree = findDuplicateSubtreesUtil(root.right,mapNode,countTreeMap,treeSet);
        String value = root.val+"-"+leftSubTree+"-"+rightSubTree;
        if(!mapNode.containsKey(value)) {
            mapNode.put(value, root);
        }
        if(!countTreeMap.containsKey(value)) {
            countTreeMap.put(value, 1);
        }
        else {
            int val = countTreeMap.get(value);
            val++;
            countTreeMap.put(value, val);
            treeSet.add(mapNode.get(value));
        }
        return value;
    }
}
