package PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode#1546
 * https://www.youtube.com/watch?v=3eewyvL6zGA
 */
public class MaximumNonOverLappingSubArraysWithSumEqualToTarget {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map= new HashMap<>();
        int prefixSum=0, availableIdx=-1, res=0;
        map.put(0,-1);
        for (int i=0; i<nums.length; i++){
            prefixSum+=nums[i];
            int remain = prefixSum - target;
            if (map.containsKey(remain) && map.get(remain)>=availableIdx){
                res++;
                availableIdx=i;
            }
            map.put(prefixSum, i);
        }
        return res;
    }}
