package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode#1609
 */
public class NumberGoodLeafNodesPairs {
    int count = 0;

    public boolean isEvenOddTree(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean b = isEvenOddTreeUtil(root, 0, true, map);
        return b;
    }

    private boolean isEvenOddTreeUtil(TreeNode root, int level, boolean isIncreasing, Map<Integer, List<Integer>> map) {
        // TODO Auto-generated method stub
        if (root == null) {
            return true;
        }
        if (level % 2 == root.val % 2) {
            return false;
        }
        if (map.containsKey(level)) {
            if (isIncreasing) {
                int valtocompare = map.get(level).get(map.get(level).size() - 1);
                if (root.val <= valtocompare) {
                    System.out.println(valtocompare + " , " + root.val);
                    return false;
                }
                map.get(level).add(root.val);
            } else {
                int valtocompare = map.get(level).get(0);
                if (root.val >= valtocompare) {
                    System.out.println(valtocompare + " , " + root.val);
                    return false;
                }
                map.get(level).add(0, root.val);
            }
        } else {
            List<Integer> integerList = new ArrayList<>();
            integerList.add(root.val);
            map.put(level, integerList);
        }
        return isEvenOddTreeUtil(root.left, level + 1, !isIncreasing, map)
                && isEvenOddTreeUtil(root.right, level + 1, !isIncreasing, map);
    }
}

