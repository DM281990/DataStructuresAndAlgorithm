package SlidngWindow;

/**
 * Leetcode#1423
 */
public class MaximumPoinYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int kExcludedLength = cardPoints.length-k;
        int sum=0;
        int totalSum=0;
        for(int i=0;i<kExcludedLength;i++) {
            sum+=cardPoints[i];
        }
        int minSum=sum;
        totalSum=sum;
        for(int i=kExcludedLength;i<cardPoints.length;i++) {
            sum-=cardPoints[i-kExcludedLength];
            sum+=cardPoints[i];
            totalSum+=cardPoints[i];
            minSum=Math.min(minSum, sum);
        }
        return totalSum-minSum;
    }
}
