package SlidngWindow;

/**
 * Failed
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/discuss/278727/C%2B%2B-O(N)-buysell-stock-2-times
 * Leetcode#1031
 */
public class MaximumSumOfTwoNonOverlappingSubArrays {
    private int MaxSum(int[] A, int L, int M)
    {
        // left to right. last L. including i.
        int[] sumL = new int[A.length];
        int[] maxL = new int[A.length];
        sumL[0] = A[0];
        maxL[0] = A[0];
        for (int i = 1; i < A.length; i++)
        {
            // sumL[i-1] + A[i] - A[i-L]
            sumL[i] = sumL[i-1] + A[i] - (i >= L ? A[i-L] : 0);
            maxL[i] = Math.max(sumL[i], maxL[i-1]);
        }

        // right to left. next M. starting i+1.
        int[] sumM = new int[A.length];
        int[] maxM = new int[A.length];
        sumM[A.length-1] = 0;
        maxM[A.length-1] = 0;
        int max = /*maxM[A.Length-1] +*/ maxL[A.length-1];
        for (int i = A.length-2; i >= 0; i--)
        {
            // sumM[i+1] + A[i+1] - A[i+M+1]
            sumM[i] = sumM[i+1] + A[i+1] - (i+M+1 < A.length ? A[i+M+1] : 0);
            maxM[i] = Math.max(sumM[i], maxM[i+1]);

            //Avoid another loop
            max = max < maxM[i] + maxL[i] ? maxM[i] + maxL[i] : max;
        }

        return max;
    }
}
