package BinaryTree;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Leetcode#114
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        flattenUtil(root,queue);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(!queue.isEmpty()){
                temp.right=queue.peek();
            }
            else{
                temp.right =null;
            }
            temp.left =null;
        }
    }

    public void flattenUtil(TreeNode root, Queue<TreeNode>queue){
        if(root ==null) return;
        queue.add(root);
        flattenUtil(root.left,queue);
        flattenUtil(root.right,queue);
    }
}
