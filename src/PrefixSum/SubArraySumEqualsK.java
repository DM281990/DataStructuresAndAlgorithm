package PrefixSum;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode#560
 */
public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        // By default count of zero sum is 1
        sumCountMap.put(0,1);
        int prefixSum =0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (sumCountMap.containsKey(prefixSum - k))
                count = count + sumCountMap.get(prefixSum - k);
            sumCountMap.compute(prefixSum,(key,val)->val!=null?val+=1:1);
        }
        return count;
    }

    /**
     * Leetcode#930
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> sumCountMap = new HashMap<>();
        // By default count of zero sum is 1
        sumCountMap.put(0,1);
        int prefixSum =0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (sumCountMap.containsKey(prefixSum - goal))
                count = count + sumCountMap.get(prefixSum - goal);
            sumCountMap.compute(prefixSum,(key,val)->val!=null?val+=1:1);
        }
        return count;
    }


    /**
     * Leetcode#974
     * @param A
     * @param K
     * @return
     */
    public int subarraysDivByK(int[] A, int K) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int runningSum = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            runningSum += A[i];
            int remainder = runningSum % K;
            if (remainder < 0)
                remainder += K;
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }


}
