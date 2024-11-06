package SlidngWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * ALGORITHM
 * Leetcode#930
 */
public class BinarySubArraysWithSum {
    public int numSubarraysWithSum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                count++;
            }
            if (sumCountMap.containsKey(prefixSum - k)) {
                count = count + sumCountMap.get(prefixSum - k);
            }
            if (sumCountMap.containsKey(prefixSum)) {
                int modifiedCount = sumCountMap.get(prefixSum);
                modifiedCount++;
                sumCountMap.put(prefixSum, modifiedCount);
            } else {
                sumCountMap.put(prefixSum, 1);
            }
        }
        return count;
    }
}
