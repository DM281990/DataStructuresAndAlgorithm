package Stack;

import java.util.Stack;

/**
 * Leetcode#150
 */
public class EvaluaeReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> integerStack = new Stack<Integer>();
        for(int i=0;i<tokens.length;i++) {
            if(tokens[i].equals("+")) {
                int operand1 = integerStack.pop();
                int operand2 = integerStack.pop();
                int val = operand1+operand2;
                integerStack.push(val);
            }
            else if(tokens[i].equals("-")) {
                int operand1 = integerStack.pop();
                int operand2 = integerStack.pop();
                int val = operand2-operand1;
                integerStack.push(val);
            }
            else if(tokens[i].equals("*")) {
                int operand1 = integerStack.pop();
                int operand2 = integerStack.pop();
                int val = operand2*operand1;
                integerStack.push(val);
            }
            else if(tokens[i].equals("/")) {
                int operand1 = integerStack.pop();
                int operand2 = integerStack.pop();
                int val = operand2/operand1;
                integerStack.push(val);
            }
            else {
                //	System.out.println(tokens[i]);
                integerStack.push(Integer.parseInt(tokens[i]));
            }
        }
        return integerStack.pop();
    }
}
