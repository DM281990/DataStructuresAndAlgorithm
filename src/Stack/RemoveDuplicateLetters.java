package Stack;

import java.util.Stack;

/**
 * Leetcode#316
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] charCount = new  int[26];
        boolean[] visited = new  boolean[26];
        for(int i=0;i<s.length();i++)
            charCount[(int)s.charAt(i)-97]++;
        String result ="";
        Stack<Character> stringStack =new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(visited[s.charAt(i)-97]) {
                charCount[s.charAt(i)-97]--;
                continue;
            }
            while(!stringStack.isEmpty()&& stringStack.peek()>s.charAt(i) && charCount[stringStack.peek()-97]>0) {
                visited[stringStack.peek()-97]=false;
                stringStack.pop();
            }
            stringStack.push(s.charAt(i));
            visited[stringStack.peek()-97]=true;
            charCount[stringStack.peek()-97]--;
        }
        while(!stringStack.isEmpty())
            result=stringStack.pop()+result;
        return result;
    }
}
