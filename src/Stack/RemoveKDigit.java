package Stack;

import java.util.Stack;

/**
 * ALGORITHM
 * https://www.youtube.com/watch?v=lWcZB7l-O7M
 * Leetcode#402
 */
public class RemoveKDigit {
    public String removeKdigits(String num, int k) {
        if(num.length()==1 && k==1) {
            return "0";
        }
        Stack<Character> stackNum = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (!stackNum.isEmpty() && stackNum.peek() > num.charAt(i) & k > 0) {
                stackNum.pop();
                k--;
            }
            if(stackNum.isEmpty()&& num.charAt(i)=='0') {
                continue;
            }
            stackNum.push(num.charAt(i));
        }
        while(k>0 && !stackNum.isEmpty()) {
            stackNum.pop();
            k--;
        }
        String res ="";
        while(!stackNum.isEmpty()) {
            if(stackNum.size()==1&&stackNum.peek()=='0') {
                break;
            }
            res=stackNum.pop()+res;
        }
        if(res.equals("")) {
            return "0";
        }
        return res;
    }
}
