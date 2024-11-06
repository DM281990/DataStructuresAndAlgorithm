package SlidngWindow;

/**
 * Leetcode#2134
 */
public class MinimumSwapsToGroupAll1sTogether {
    public int minSwaps(int[] nums) {
        int[] numsCircular = new int[nums.length * 2];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            numsCircular[i] = nums[i];
            numsCircular[i + nums.length] = nums[i];
        }
        int i = 0;
        int j = 0;
        int minZeros = 0;
        int zeroCount = 0;
        while (j < count) {
            if (numsCircular[j] == 0) {
                zeroCount++;
            }
            j++;
        }
        minZeros = zeroCount;
        //check circular
        while (j < numsCircular.length) {
            if (numsCircular[j] == 0) {
                zeroCount++;
            }
            if (numsCircular[i] == 0) {
                zeroCount--;
            }
            minZeros = Math.min(minZeros, zeroCount);
            i++;
            j++;
        }
        return minZeros;
    }
}
