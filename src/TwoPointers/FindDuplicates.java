package TwoPointers;

/**
 * LEETCODE#287
 */
public class FindDuplicates {

    /**
     * Without using extra space
     * https://www.youtube.com/watch?v=_n5MR8IxR6c
     * @param nums : mark visited elements as -ve
     * @return
     */
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int ind = Math.abs(nums[i]);
            if(nums[ind] < 0) {
                return ind;
            }
            nums[ind] = -nums[ind];
        }
        return -1;
    }

    /**
     * Hair tottoise
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do { // we are sure that at least one duplicate is there
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        // find the head of loop
        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
