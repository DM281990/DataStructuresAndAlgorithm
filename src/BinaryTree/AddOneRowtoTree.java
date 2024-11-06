package BinaryTree;

import util.TreeNode;

/**
 * Leetcode#623
 */
public class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1) {
            TreeNode node = new TreeNode(val,root,null);
            return node;
        }
        addOneRowUtil( root,  val,  depth-2);
        return root;
    }

    private void addOneRowUtil(TreeNode root, int val, int depth) {
        if(root==null) {
            return;
        }
        if(depth==0) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=left;
            root.right.right=right;
            return;
        }
        addOneRowUtil( root.left,  val,  depth-1);
        addOneRowUtil( root.right,  val,  depth-1);
    }
}
