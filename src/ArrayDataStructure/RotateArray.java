package ArrayDataStructure;

/**
 * Leetcode#189
 */
public class RotateArray {
    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    public void rotate(int[] nums, int k) {
        int[]nums1 = new int[nums.length];
        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }
        k = k%nums.length;
        if(k==0){
            return;
        }
        int index=0;
        int listIndex = nums.length-k;
        for (int i=listIndex;i<nums.length;i++){
            nums1[index++]=nums[i];
        }
        for(int i=0;i<listIndex;i++){
            nums1[index++]=nums[i];
        }
        for (int i=0;i<nums1.length;i++){
            nums[i]= nums1[i];
        }
    }
}
