package BinaryTree;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode#1457
 */
public class PseudoPalindromicPath {
    public int pseudoPalindromicPaths(TreeNode root) {
        Map<Integer,Integer> nodeCountMap=new HashMap<>();
        return pseudoPalindromicPathsUtil(root,nodeCountMap,1);
        //System.out.println(result);
        //return result;
    }

    private int pseudoPalindromicPathsUtil(TreeNode root, Map<Integer, Integer> nodeCountMap, int length) {
        if(root==null) {
            return 0;
        }
        if(nodeCountMap.containsKey(root.val)) {
            int val =nodeCountMap.get(root.val);
            val++;
            nodeCountMap.put(root.val,val);
        }
        else {
            nodeCountMap.put(root.val, 1);
        }
        if(root.right==null && root.left==null) {
            if(length%2==0) {
                boolean isPalindrome =true;
                for(Integer i:nodeCountMap.keySet()) {
                    if(nodeCountMap.get(i)%2==1) {
                        isPalindrome =false;
                    }
                }
                removeNodesFromMap(root, nodeCountMap);
                if(isPalindrome) {
                    return 1;
                }
                return 0;
            }
            else if(length%2==1) {
                int oddCount =0;
                for(Integer i:nodeCountMap.keySet()) {
                    if(nodeCountMap.get(i)%2==1) {
                        oddCount++;
                    }
                }
                removeNodesFromMap(root, nodeCountMap);
                if(oddCount==1) {
                    return 1;
                }
                return 0;
            }
        }
        int leftPalinDrome = pseudoPalindromicPathsUtil(root.left,nodeCountMap,length+1);
        int rightPalinDrome = pseudoPalindromicPathsUtil(root.right,nodeCountMap,length+1);
        removeNodesFromMap(root, nodeCountMap);
        return leftPalinDrome+rightPalinDrome;
    }
    private void removeNodesFromMap(TreeNode root, Map<Integer, Integer> nodeCountMap) {
        if(nodeCountMap.get(root.val)>1) {
            int val =nodeCountMap.get(root.val);
            val--;
            nodeCountMap.put(root.val,val);
        }
        else {
            nodeCountMap.remove(root.val);
        }
    }
}
