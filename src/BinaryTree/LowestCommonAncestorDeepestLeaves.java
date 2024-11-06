package BinaryTree;

import util.TreeNode;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Leetcode#1123
 */
public class LowestCommonAncestorDeepestLeaves {

    public static void main(String[] args) {
        new LowestCommonAncestorDeepestLeaves().lcaDeepestLeaves(
                new TreeNode(2, new TreeNode(5, new TreeNode(6),new TreeNode(2, new TreeNode(7),new TreeNode(4))),
                        new TreeNode(1,new TreeNode(0),new TreeNode(8)))
        );
    }

    /**
     * Leetcode#865
     * @param root
     * @return
     */
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return lcaDeepestLeaves(root);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root ==null) return null;
        TreeMap<Integer,TreeNode> val=lcaDeepestLeavesUtil(root,0);
        return val.firstEntry().getValue();
    }

    private TreeMap<Integer, TreeNode> lcaDeepestLeavesUtil(TreeNode root, int level) {
        TreeMap<Integer,TreeNode> val = new TreeMap<>();
        if(root ==null) return null;
        if(root.right==null && root.left ==null) {
            val.put(level,root);
            return val;
        }
        TreeMap<Integer, TreeNode> left = lcaDeepestLeavesUtil(root.left,level+1);
        TreeMap<Integer, TreeNode> right = lcaDeepestLeavesUtil(root.right,level+1);
        if(left == null) return right;
        if(right ==null) return left;
        if(Objects.equals(left.firstEntry().getKey(), right.firstEntry().getKey())){
            left.put(left.firstEntry().getKey(),root);
            return left;
        }
        else if (left.firstEntry().getKey()>right.firstEntry().getKey()) return left;
        return right;
    }
}


