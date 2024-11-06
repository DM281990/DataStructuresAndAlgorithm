package BinaryTree;

import util.TreeNode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Leetcode#508
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        findFrequentTreeSumUtil(root, result);
        Map<Integer,Long> resultMap=result.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        TreeMap<Long,List<Integer>> finalResult =new TreeMap<>(Collections.reverseOrder());
        for(Integer key:resultMap.keySet()){
            if(!finalResult.containsKey(resultMap.get(key))){
                finalResult.put(resultMap.get(key),new ArrayList<>());
            }
            finalResult.get(resultMap.get(key)).add(key);
        }
        List<Integer> finalList = finalResult.firstEntry().getValue();
        int[] finalListint = new int[finalList.size()];
        for(int i=0;i<finalListint.length;i++){
            finalListint[i]=finalList.get(i);
        }
        return finalListint;
    }

    private int findFrequentTreeSumUtil(TreeNode root, List<Integer> result) {
        if (root == null) return 0;
        int leftSum = findFrequentTreeSumUtil(root.left, result);
        int rightSum = findFrequentTreeSumUtil(root.right, result);
        int sum = leftSum + rightSum + root.val;
        result.add(sum);
        return sum;
    }
}
