package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode#538
 */
public class ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        inOrderTraversal(root,nodeList);
        for(int i=nodeList.size()-2;i>=0;i--)nodeList.get(i).val+=nodeList.get(i+1).val;
        return root;
    }

    private void inOrderTraversal(TreeNode root, List<TreeNode> nodeList) {
        if(root==null)return;
        inOrderTraversal(root.left,nodeList);
        nodeList.add(root);
        inOrderTraversal(root.right,nodeList);
    }
}
