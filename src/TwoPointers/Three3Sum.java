package TwoPointers;

import java.util.*;

/**
 * LeetCode#15
 */
public class Three3Sum {

    public static void main(String[] args) {
        new Three3Sum().threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> ripletSet = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            int j =i+1; int k= nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0){
                    j++;
                }
                else if (sum>0){
                    k--;
                }
                else{
                    if(ripletSet.add(nums[i]+","+nums[j]+","+nums[k])){
                        result.add(List.of(nums[i],nums[j],nums[k]));
                    }
                    j++;
                    k--;
                }
            }
        }
        return result;
    }
}
