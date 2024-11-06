package PrefixSum;

/**
 * Leetcode#1658
 */
public class MinimumOperationstoReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        int targetSum = sum - x;
        if(targetSum<0)
            return -1;
        if(sum==x)
            return nums.length;
        int i = 0, j = 0,currSum = 0,width = 0;
        while (j < nums.length) {
            currSum += nums[j];
            while (currSum > targetSum) {
                currSum -= nums[i];
                i++;
            }
            if (currSum == targetSum)
                width =Math.max(width,j-i+1);
            j++;
        }
        if (width == 0)
            return -1;
        return nums.length - width;
    }
}
