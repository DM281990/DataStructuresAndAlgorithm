package BinaryTree;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class CheckCompletenessOfBinaryTree {
    public static void main(String[] args) {
        new CheckCompletenessOfBinaryTree().isCompleteTree(
                new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,null,new TreeNode(7)))
        );
    }
    public boolean isCompleteTree(TreeNode root) {
        Map<Integer, Integer> mapArray = new HashMap<>();
        int maxIndex[]=new int[1];
        isCompleteTreeUtil(root, mapArray,maxIndex, 1);
        for(int i=1;i<=maxIndex[0];i++) {
            if(mapArray.get(i)==null) {
                return false;
            }
        }
        return true;
    }

    private void isCompleteTreeUtil(TreeNode root, Map<Integer, Integer> mapArray, int[] maxIndex, int index) {
        if (root == null) {
            return;
        }
        mapArray.put(index, root.val);
        maxIndex[0]=Math.max(index, maxIndex[0]);
        isCompleteTreeUtil(root.left, mapArray,maxIndex, 2*index);
        isCompleteTreeUtil(root.right, mapArray,maxIndex, 2*index+1);
    }

}
