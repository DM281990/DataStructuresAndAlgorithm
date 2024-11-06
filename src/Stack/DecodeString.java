package Stack;

import java.util.Stack;

/**
 * Leetcode#394
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stringStack.push("[");
            } else if (s.charAt(i) == ']') {
                String res = "";
                while (!stringStack.peek().equals("[")) {
                    res = stringStack.pop() + res;
                }
                String repeatString = res;
                stringStack.pop();
                if (!stringStack.isEmpty()) {
                    String integer = "";
                    while (!stringStack.isEmpty()&&Character.isDigit(stringStack.peek().charAt(0))) {
                        integer = stringStack.pop() + integer;
                    }
                    int k = Integer.parseInt(integer);
                    for (int j = 0; j < k - 1; j++) {
                        res += repeatString;
                    }
                }
                stringStack.push(res);
            } else {
                stringStack.push(s.charAt(i) + "");
            }
        }

        String result = "";
        while (!stringStack.isEmpty()) {
            result = stringStack.pop() + result;
        }
        return result;
    }
}
