package BinaryTree;

import util.TreeNode;

import java.util.Stack;

/**
 * Leetcode#173
 */
public class BinarySearchTreeIterator {
    Stack<TreeNode>nodeStack= new Stack<>();
    int peekValue = 0;
    public BinarySearchTreeIterator(TreeNode root) {
        if(root!=null) {
            inOrderTraversal(root, nodeStack);
        }

    }
    public void inOrderTraversal(TreeNode root,Stack<TreeNode> nodeStack){
        if(root==null) {
            return;
        }
        inOrderTraversal(root.right,nodeStack);
        nodeStack.push(root);
        inOrderTraversal(root.left,nodeStack);
    }
    public int next() {
        if(hasNext()) {
            this.peekValue= nodeStack.pop().val;
        }
        return peekValue;

    }

    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }
}
