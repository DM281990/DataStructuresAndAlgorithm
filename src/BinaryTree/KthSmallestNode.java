package BinaryTree;

import util.TreeNode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode#230
 */
public class KthSmallestNode {
    public static void main(String[] args) {
        new KthSmallestNode().kthSmallest(
                new TreeNode(3, new TreeNode(1,null,new TreeNode(2)),new TreeNode(4,null,null)),2);

    }
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue <Integer> queue = new PriorityQueue<>(k,Collections.reverseOrder());
        kthSmallestUtil(root,queue,k);
        int val=-1;
        if(!queue.isEmpty()){
            val =queue.poll();
        }
        return val;
    }

    private void kthSmallestUtil(TreeNode root, PriorityQueue<Integer> queue, int k) {
        if(root ==null)return;
        if(queue.size()<k)queue.add(root.val);
        else if(queue.size()==k && queue.peek()>root.val){
            queue.poll();
            queue.add(root.val);
        }
        kthSmallestUtil(root.left, queue,k);
        kthSmallestUtil(root.right, queue,k);
    }
}
