package TwoPointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode#532
 */
public class KDiffArray {
    public int findPairs(int[] nums, int k) {
        if(nums.length ==0 || nums.length==1) return 0;
        Arrays.sort(nums);
        int i=0, j = i+1;
        Set<String> diffAssayset = new HashSet<>();
        String result ="";
        int count =0;
        while(j<nums.length){
            if(nums[i]+k >nums[j]){
                j++;
            }
            else if(nums[i]+k <nums[j]){
                i++;
                if(i==j){
                    j++;
                }
            }
            else{
                if(diffAssayset.add(nums[i]+","+nums[j])){
                    count ++;
                }
                i++;
                j++;
            }
        }
        return count;
    }
}
