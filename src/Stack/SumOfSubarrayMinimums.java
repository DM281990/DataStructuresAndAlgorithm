package Stack;

import java.util.Stack;

/**
 * ALGORITHM
 * https://www.youtube.com/watch?v=v0e8p9JCgRc
 * Leetcode#907
 */
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        int[] nextSmallerElements = getNextSmallerElements(arr);
        int[] previousSmallerElements = getPreviousSmallerElements(arr);
        double sum =0;
        double mod = Math.pow(10, 9)+7;
        for(int i=0;i<arr.length;i++) {
            sum =sum%mod +arr[i]%mod*(nextSmallerElements[i]-i)%mod*(i-previousSmallerElements[i])%mod;
            sum=sum%mod;
        }
        return (int)sum;
    }

    private int[] getPreviousSmallerElements(int[] heights) {
        int ps[] = new int[heights.length];
        Stack<Integer> inputStack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!inputStack.isEmpty() && heights[inputStack.peek()] >= heights[i]) {
                inputStack.pop();
            }
            if (inputStack.isEmpty()) {
                ps[i] = -1;
            } else {
                ps[i] = inputStack.peek();
            }
            inputStack.push(i);
        }
        return ps;
    }

    private int[] getNextSmallerElements(int[] heights) {
        int ps[] = new int[heights.length];
        Stack<Integer> inputStack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!inputStack.isEmpty() && heights[inputStack.peek()] > heights[i]) {
                inputStack.pop();
            }
            if (inputStack.isEmpty()) {
                ps[i] = heights.length;
            } else {
                ps[i] = inputStack.peek();
            }
            inputStack.push(i);
        }
        return ps;
    }

    public int sumSubarrayMins1(int[] arr) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        long mod = (long)1000000007;
        st.push(-1);
        for (int i= 0; i < arr.length+1; i++){
            int currVal = (i<=arr.length-1)? arr[i] : 0;
            while(st.peek() !=-1 && currVal<arr[st.peek()]){
                int index = st.pop();
                int j = st.peek();
                int left = index - j;
                int right = i - index;
                long add = (left * right * (long)arr[index]) % mod;
                ans += add ;
                ans %= mod;
            }
            st.push(i);
        }
        return ans;
    }
}
