package Stack;

import java.util.Stack;

/**
 * Leetcode#1249
 * https://www.youtube.com/watch?v=NNxaYz0nrk0
 */
public class MinimumRemoveToMakeParenthesisBalanced {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < sb.length(); ++i) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty()) st.pop();
                else sb.setCharAt(i, '*');
            }
        }
        while (!st.empty())
            sb.setCharAt(st.pop(), '*');
        return sb.toString().replaceAll("\\*", "");
    }
    /*
    1541. Minimum Insertions to Balance a Parentheses String
    Refer https://www.youtube.com/watch?v=NNxaYz0nrk0
     */

    /**
     * Leetcode#1963
     * @param s
     * @return
     */
    public int minSwaps(String s) {
        int count = 0;
        int maxCount = 0;
        char[] charrArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (charrArray[i] == ']') {
                count++;
            } else if (charrArray[i] == '[') {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return (maxCount + 1) / 2;
    }
}
