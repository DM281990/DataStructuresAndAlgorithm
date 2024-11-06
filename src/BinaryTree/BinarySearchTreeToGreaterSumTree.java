package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeToGreaterSumTree {
    public TreeNode bstToGst(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root,list);
        for(int i=list.size()-2;i>=0;i--){
            list.get(i).val += list.get(i+1).val;
        }
        return root;
    }
    public void inorder(TreeNode root , List<TreeNode> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root);
        inorder(root.right,list);
    }
}
