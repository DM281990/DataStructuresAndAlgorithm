package Stack;

import java.util.Stack;

/**
 * Leetcode#921
 */
public class MinimumAddMakeParenthesesValid {
    public int minAddToMakeValid(String s) {
        char[] charrArray = s.toCharArray();
        Stack<Character> stackArray = new Stack<>();
        for (int i = 0; i < charrArray.length; i++) {
            if(!stackArray.isEmpty() && stackArray.peek()=='('&& charrArray[i]==')') {
                stackArray.pop();
                continue;
            }
            stackArray.push(charrArray[i]);
            //	maxCount = Math.max(maxCount, count);
        }
        return stackArray.size();
    }
}
