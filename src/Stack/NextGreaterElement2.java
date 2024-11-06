package Stack;

import java.util.Stack;

/**
 * Leetcode#503
 */
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] numsMerged = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsMerged[i] = nums[i];
            numsMerged[nums.length + i] = nums[i];
        }
        int[] ngeArray = nextGreaterElement(numsMerged);
        int[] ngArrayFinal = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ngArrayFinal[i] = ngeArray[i];

        }

        return ngArrayFinal;
    }

    public int[] nextGreaterElement(int[] nums) {
        int[] nextGreaterElementArray = new int[nums.length];
        Stack<Integer> ngStack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!ngStack.isEmpty() && ngStack.peek() <= nums[i]) {
                ngStack.pop();
            }
            if (!ngStack.isEmpty()) {
                nextGreaterElementArray[i] = ngStack.peek();
            } else {
                nextGreaterElementArray[i] = -1;
            }
            ngStack.push(nums[i]);
        }
        return nextGreaterElementArray;
    }
}
