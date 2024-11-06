package BinaryTree;

import java.util.Stack;

public class VerifyPreOrderSerializaion {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
    public boolean isValidSerialization1(String preorder) {
        Stack<String> preOrderStack  =new Stack<>();
        String[] stringArray = preorder.split(",");

        for(int i=0;i<stringArray.length;i++) {
            String input = stringArray[i];
            while(!preOrderStack.isEmpty() && preOrderStack.peek().equals("#") && input.equals("#")) {
                String popped = preOrderStack.pop();
                if(preOrderStack.isEmpty()) {
                    return false;
                }
                popped = preOrderStack.pop();
                if(!Character.isDigit(popped.charAt(0))) {
                    return false;
                }
            }
            preOrderStack.push(input);
        }
        if(preOrderStack.isEmpty()||(preOrderStack.size()==1 && preOrderStack.pop().equals("#"))) {
            return true;
        }
        return false;
    }
}
