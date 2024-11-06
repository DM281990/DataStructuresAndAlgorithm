package SlidngWindow;

/**
 * Leetcode#209
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,length=nums.length+1;
        int sum=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                length = Math.min(length,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return length== nums.length+1?0:length;
    }
}
