package SlidngWindow;

/**
 * Algorithm
 * Leetcode#1004
 */
public class MaximumConsecutive1s3 {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0,maxLength=0;
        while(j<nums.length) {
            if (nums[j] == 0) {
                k--;
                while (k < 0) {
                    if(nums[i]==0)k++;
                    i++;
                }
            }
            maxLength=Math.max(maxLength,j-i+1);
            j++;
        }
        return maxLength;
    }
}
