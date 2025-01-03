package DynamicProgramming;

/**
 * Leetcode#718
 */
public class MaximumLengthOfRepeatedSubArray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][]dp = new int[nums1.length+1][nums2.length+1];
        int max=0;
        for(int i=1;i<nums1.length+1;i++) {
            for(int j=1;j<nums2.length+1;j++) {
                if(nums1[i-1]==nums2[j-1]) {
                    dp[i][j]=1+dp[i-1][j-1];
                    max =Math.max(max, dp[i][j]);
                }
                else {
                    dp[i][j]=0;
                }
            }
        }
        return max;
    }
}
