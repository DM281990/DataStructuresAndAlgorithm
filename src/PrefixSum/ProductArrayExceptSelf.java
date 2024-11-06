package PrefixSum;

import java.util.Arrays;

/**
 * Leetcode#238
 */
public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        new ProductArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4});
    }
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProd = new int[nums.length];
        int[] suffixProd = new int[nums.length];
        int product[] = new int[nums.length];
        Arrays.fill(prefixProd,1);
        Arrays.fill(suffixProd,1);
        for(int i=1;i<nums.length;i++){
            prefixProd[i] = prefixProd[i-1]*nums[i-1];
            suffixProd[nums.length-i-1]=suffixProd[nums.length-i]*nums[nums.length-i];
        }
        for(int i=0;i<nums.length;i++){
            product[i] =prefixProd[i]*suffixProd[i];
        }
        return product;
    }
}
