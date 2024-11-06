package BinaryTree;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaximumBinaryTree2 {
    public static void main(String[] args) {
        new MaximumBinaryTree2().insertIntoMaxTree(
                new TreeNode(4, new TreeNode(1),new TreeNode(3,new TreeNode(2),null))
                ,5);
    }
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeMap<Integer,TreeNode> map = new TreeMap<>();
        insertIntoMaxTreeUtil(root,val,1,map);
        map.put(map.lastKey()+1,new TreeNode(val) );
        if(map.lastKey()%2==0){
            map.get(map.lastKey()/2).left=map.get(map.lastKey());
        }else{
            map.get(map.lastKey()/2).right=map.get(map.lastKey());
        }
        int key = map.lastKey();
        while(key/2>0 && map.get(key).val>map.get(key/2).val){
            int temp = map.get(key).val;
            map.get(key).val=map.get(key/2).val;
            map.get(key/2).val=temp;
            key=key/2;
        }
        return root;
    }

    private void insertIntoMaxTreeUtil(TreeNode root, int val, int index,Map<Integer,TreeNode> map) {
        if(root ==null)return;
        map.put(index,root);
        insertIntoMaxTreeUtil(root.left,val,2*index,map);
        insertIntoMaxTreeUtil(root.right,val,2*index+1,map);
    }
}
