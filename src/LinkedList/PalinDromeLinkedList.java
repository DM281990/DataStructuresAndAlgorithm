package LinkedList;

import util.ListNode;

import java.util.Stack;

/**
 * Leetcode#234
 */
public class PalinDromeLinkedList {
    public static void main(String[] args) {
        new PalinDromeLinkedList().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(2,new ListNode(1))))));
    }
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack();
        ListNode curr = head;
        while(curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while(curr != null && curr.val == stack.pop()) {
            curr = curr.next;
        }
        return curr == null;
    }
}
