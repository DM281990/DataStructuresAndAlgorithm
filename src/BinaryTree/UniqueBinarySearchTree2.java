package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode#95
 */
public class UniqueBinarySearchTree2 {
    public static void main(String[] args) {
        new UniqueBinarySearchTree2().generateTrees(3);
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = generateTreesUtil(1,n);
        return list;
    }

    private List<TreeNode> generateTreesUtil(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end)
        {
            list.add(null);
            return list;
        }
        if (start == end) return List.of(new TreeNode(start));
        for (int i = start; i <= end; i++) {
            List<TreeNode> lst  = generateTreesUtil(start, i - 1);
            List<TreeNode> rst = generateTreesUtil(i + 1, end);
            for(TreeNode left:lst)
                for(TreeNode right:rst)
                    list.add(new TreeNode(i,left,right));
        }
        return list;
    }
}
