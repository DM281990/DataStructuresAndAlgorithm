package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode#863
 */
public class AllNodesDistanceK {
    public static void main(String[] args) {
        new AllNodesDistanceK().distanceK(
                new TreeNode(3,new TreeNode(5,new TreeNode(6),new TreeNode(2,new TreeNode(7),new TreeNode(4))),new TreeNode(1,new TreeNode(0),new TreeNode(8)))
                ,new TreeNode(5),2);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
        int i = distanceKUtil(root,target,k,list);
        return list;
    }

    private int distanceKUtil(TreeNode root, TreeNode target, int k,List<Integer> list) {
        if(root == null)return 0;
        if(root.val==target.val){
            findDistanceKDown(root,list,k);
            return 1;
        }
        int leftDist = distanceKUtil(root.left,target,k,list);
        int rightDist = distanceKUtil(root.right,target,k,list);
        if(leftDist!=0){
            if(k-leftDist==0)list.add(root.val);
            findDistanceKDown(root.right,list,k-leftDist-1);
            return 1+leftDist;
        }
        else if (rightDist!=0){
            if(k-rightDist==0)list.add(root.val);
            findDistanceKDown(root.left,list,k-rightDist-1);
            return 1+rightDist;
        }
        return 0;
    }

    private void findDistanceKDown(TreeNode root, List<Integer> list, int k) {
        if(root ==null || k<0)return;
        if(k==0){list.add(root.val);return;};
        findDistanceKDown(root.left,list,k-1);
        findDistanceKDown(root.right,list,k-1);
    }
}
