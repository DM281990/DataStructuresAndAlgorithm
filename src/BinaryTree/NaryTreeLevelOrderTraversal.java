package BinaryTree;

import util.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Leetcode#429
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        levelOrderUtil(root,map,0);
        return new ArrayList<>(map.values());
    }

    private void levelOrderUtil(Node root, TreeMap<Integer, List<Integer>> map,int level) {
        if(root==null)return;
        if(!map.containsKey(level))map.put(level,new ArrayList<>());
        map.get(level).add(root.val);
        for(int i=0;i<root.children.size();i++)levelOrderUtil(root.children.get(i),map,level+1);
    }
}
