package Stack;

import java.util.Stack;

/**
 * Leetcode#735
 */
public class AsteroidCollection {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int asteroid: asteroids){
            if(asteroid > 0){
                s.push(asteroid);
            }else{// i is negative
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroid)){
                    s.pop();
                }
                if(s.isEmpty() || s.peek() < 0){
                    s.push(asteroid);
                }else if(asteroid + s.peek() == 0){
                    s.pop(); //equal
                }
            }
        }
        int[] res = new int[s.size()];
        for(int i = res.length - 1; i >= 0; i--){
            res[i] = s.pop();
        }
        return res;
    }

    /**
     * Leetcode#739
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] nnextGreaterTemperatureIndex = nextGreaterElement(temperatures);
        for(int i=0;i<nnextGreaterTemperatureIndex.length;i++) {
            if(nnextGreaterTemperatureIndex[i]==-1) {
                nnextGreaterTemperatureIndex[i]=0;
            }
            else {
                nnextGreaterTemperatureIndex[i]=nnextGreaterTemperatureIndex[i]-i;
            }
        }
        return nnextGreaterTemperatureIndex;
    }

    public int[] nextGreaterElement(int[] nums) {
        int[] nextGreaterElementArray = new int[nums.length];
        Stack<Integer> ngStack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {

            while (!ngStack.isEmpty() && nums[ngStack.peek()] <= nums[i]) {
                ngStack.pop();
            }
            if (!ngStack.isEmpty()) {
                nextGreaterElementArray[i] = ngStack.peek();
            } else {
                nextGreaterElementArray[i] = -1;
            }
            ngStack.push(i);
        }
        return nextGreaterElementArray;
    }
}
