package TwoPointers.LexicographicallyNext;

/**
 * Leetcode#556
 */
public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        String s= n+"";
        int[]nums = new int[s.length()];
        for(int i=nums.length-1;i>=0;i--){
           nums[i] = n%10;
           n=n/10;
        }
        nextPermutation(nums);
        int res =0;
        for(int i=0;i<nums.length;i++){
            res+=res*10+nums[i];
        }
        if(n==res){
            return -1;
        }
        return res;
    }


    public void nextPermutation(int[] nums) {
        int ind1=-1;
        int ind2=-1;
        // step 1 find breaking point
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind1=i;
                break;
            }
        }
        // if there is no breaking  point
        if(ind1==-1){
            return;
        }

        else{
            // step 2 find next greater element and swap with ind2
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[ind1]){
                    ind2=i;
                    break;
                }
            }

            swap(nums,ind1,ind2);
            // step 3 reverse the rest right half
            reverse(nums,ind1+1);
        }
    }

    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

}
