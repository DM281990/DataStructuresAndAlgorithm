package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Leetcode#99
 */
public class RecoverBinarySearchTree {

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recoverTreeUtil(root,list);
        int j=1;
        while(j<list.size()){
            int i=j;
            while(j>=1 && list.get(j).val<list.get(j-1).val){
                int temp = list.get(j-1).val;
                list.get(j-1).val=list.get(j).val;
                list.get(j).val=temp;
                j--;
            }
            j=i;j++;
        }
    }

    private void recoverTreeUtil(TreeNode root, List<TreeNode> list) {
        if(root ==null)return;
        recoverTreeUtil(root.left,list);
        list.add(root);
        recoverTreeUtil(root.right,list);
    }

}
