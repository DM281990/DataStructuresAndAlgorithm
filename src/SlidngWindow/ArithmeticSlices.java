package SlidngWindow;

/**
 * Leecode#413
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            if(nums[i] - nums[i + 1] == nums[i + 1] - nums[i + 2]) {
                ans += task(i, i + 2, nums);
            }
        }

        return ans;
    }

    static int task(int start, int end, int[] nums) {
        if(end + 1 == nums.length) return 1;

        if(nums[end] - nums[end + 1] == nums[end - 1] - nums[end]) {
            return 1 + task(start, end + 1, nums);
        }
        else {
            return 1;
        }
    }
}
