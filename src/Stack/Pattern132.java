package Stack;

import java.util.Stack;

/**
 * Leetcode#456
 */
public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        int secondMax =Integer.MIN_VALUE;
        Stack<Integer> stackNum = new Stack<>();
        int min =Integer.MAX_VALUE;
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i]<secondMax) {
                return true;
            }
            while(!stackNum.isEmpty() && stackNum.peek()<nums[i]) {
                secondMax = Math.max(secondMax, stackNum.pop());
            }
            stackNum.push(nums[i]);
        }
        return false;
    }
}
