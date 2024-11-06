package BinaryTree.BinarySearchTree;

import com.sun.source.tree.Tree;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodesQueriesBinarySearchTree {
    public static void main(String[] args) {
        new ClosestNodesQueriesBinarySearchTree().closestNodes(
          new TreeNode(6,new TreeNode(2, new TreeNode(1),new TreeNode(4)),
                  new TreeNode(13,new TreeNode(9),new TreeNode(15,new TreeNode(14),null)))
                ,List.of(2,5,16)
        );
    }
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<queries.size();i++){
            List<Integer> result = closestNodesUtil(root,queries.get(i),Integer.MIN_VALUE,Integer.MAX_VALUE);
            list.add(result);
        }
        return list;
    }

    private List<Integer> closestNodesUtil(TreeNode root, Integer val, int minValue, int maxValue) {
        if(root ==null)return List.of(minValue,maxValue);
        if(val<=root.val){
            minValue = Math.max(minValue,root.val);
        }
        if(val>=root.val){
            maxValue = Math.min(maxValue,root.val);
        }
        List<Integer> leftVal = closestNodesUtil(root.left,val,minValue,maxValue);
        List<Integer> rightVal = closestNodesUtil(root.right,val,minValue,maxValue);
        return List.of(Math.max(leftVal.get(0),rightVal.get(0)),Math.min(leftVal.get(1),rightVal.get(1)));
    }
}
