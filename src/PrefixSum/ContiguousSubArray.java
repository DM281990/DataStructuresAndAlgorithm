package PrefixSum;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Leetcode#525
 */
public class ContiguousSubArray {
    public static void main(String[] args) {
        new ContiguousSubArray().longestWPI(new int[]{9,6,9});
    }
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++)nums[i]=nums[i]==0?-1:nums[i];
        Map<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,-1);
        int sum=0,result=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sumMap.containsKey(sum))result=Math.max(result,i-sumMap.get(sum));
            else sumMap.put(sum,i);
        }
        return result;
    }

    /**
     *
     * We starts with a score = 0,
     * If the working hour > 8, we plus 1 point.
     * Otherwise we minus 1 point.
     * We want find the maximum interval that have strict positive score.
     *
     *
     * After one day of work, if we find the total score > 0,
     * the whole interval has positive score,
     * so we set res = i + 1.
     *
     *
     * If the score is a new lowest score, we record the day by seen[cur] = i.
     * seen[score] means the first time we see the score is seen[score]th day.
     *
     *
     * We want a positive score, so we want to know the first occurrence of score - 1.
     * score - x also works, but it comes later than score - 1.
     * So the maximum interval is i - seen[score - 1]
     * Leetcode#1124
     * @param hours
     * @return
     */
    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }
}
