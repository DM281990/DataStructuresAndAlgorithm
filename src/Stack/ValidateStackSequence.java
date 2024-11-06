package Stack;

import java.util.Stack;

/**
 * Leetcode#946
 */
public class ValidateStackSequence {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> pushStack = new Stack<Integer>();
        Stack<Integer> popStack = new Stack<Integer>();
        Stack<Integer> workingStack = new Stack<Integer>();
        for (int i = pushed.length-1; i >= 0; i--) {
            pushStack.push(pushed[i]);
        }
        for (int i = popped.length-1; i >= 0; i--) {
            popStack.push(popped[i]);
        }
        while (!pushStack.isEmpty() || !popStack.isEmpty()) {
            if (!workingStack.isEmpty() && !popStack.isEmpty() && popStack.peek().equals(workingStack.peek())) {
                workingStack.pop();
                popStack.pop();
                //System.out.println("POPPED-"+ popStack.pop());
            }
            else {
                if(pushStack.isEmpty()) {
                    return false;
                }
                //System.out.println("PUSHED-"+ pushStack.peek());
                workingStack.push(pushStack.pop());
            }
        }
        return true;
    }
}
