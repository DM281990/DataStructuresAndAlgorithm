package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Leetcode#199
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap <Integer,Integer> lefSideView = new TreeMap<>();
        rightSideViewUtil(root,lefSideView,0);
        return new ArrayList<>(lefSideView.values());
    }

    private void rightSideViewUtil(TreeNode root, TreeMap<Integer, Integer> lefSideView, int level) {
        if(root ==null) return;
        rightSideViewUtil(root.left,lefSideView,level+1);
        lefSideView.put(level,root.val);
        rightSideViewUtil(root.right,lefSideView,level+1);
    }

}
