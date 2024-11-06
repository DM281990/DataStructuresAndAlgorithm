package Stack;

import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=dUQRS4luBvA
 * Leetcode#1190
 */
public class ReverseSubStringBetweenEachPairOfParenthesis {
    public String reverseParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char currentChar : s.toCharArray()) {
            if (currentChar == '(')
                stack.push(result.length());
            else if (currentChar == ')') {
                int start = stack.pop();
                reverse(result, start, result.length() - 1);
            } else result.append(currentChar);
        }
        return result.toString();
    }
    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }
}
