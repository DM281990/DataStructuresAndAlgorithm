package BinaryTree;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode#113
 */
public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        String resultString="";
        pathSumUtil(root,result,resultString,targetSum);
        return result;
    }

    private void pathSumUtil(TreeNode root, List<List<Integer>> result, String resultString, int targetSum) {
        if(root ==null) return;
        if(root.left==null && root.right==null &targetSum==root.val){
            System.out.println(resultString);
            String[]st = resultString.split(",");
            List<Integer> stList = new ArrayList<>();
            for(int i=0;i<st.length;i++){
                if(st[i].trim().length()==0)continue;
                stList.add(Integer.parseInt(st[i]));
            }
            stList.add(root.val);
            result.add(stList);
            return;
        }
        pathSumUtil(root.left,result,resultString+","+root.val,targetSum-root.val);
        pathSumUtil(root.right,result,resultString+","+root.val,targetSum-root.val);
    }
}
