package PrefixSum;

/**
 * Leetcode#1685
 */
public class SumOfAbsoluteDifference {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i==0) {
                result[i]=sum[nums.length-1]-nums.length*nums[i];
            }
            else {
                //-ve results
                result[i]+=(sum[nums.length-1]-sum[i])-(nums.length-i-1)*nums[i];
                //+ve results
                result[i]+=(i+1)*nums[i]-sum[i];
            }

        }
        return result;
    }
}
