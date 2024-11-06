package Stack;

import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=mcJBhWXel-Y
 * ALGORITHM
 * Leetcode#962
 */
public class MaximumWidthRamp {
    public static void main(String[] args) {
        new MaximumWidthRamp().maxWidthRamp(new int[]{6,0,8,2,1,5});
    }
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> numberRamp = new Stack<>();
        int rampSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if(numberRamp.isEmpty() ||nums[i] < nums[numberRamp.peek()] ) {
                numberRamp.push(i);
            }
        }

        for (int j = nums.length - 1; j > rampSize; j--) {
            while (!numberRamp.isEmpty() && nums[j] >= nums[numberRamp.peek()]) {
                rampSize = Math.max(rampSize, j - numberRamp.pop());
            }
        }

        return rampSize;
    }
}
