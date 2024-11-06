package LinkedList;

import util.ListNode;

import java.util.Stack;

/**
 * Leetcode#82 failed
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        new RemoveDuplicates().deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        Stack<ListNode> listNodeStack = new Stack<>();
        ListNode tempNode = head;
        if (head != null) {
            return null;
        }
        ListNode dummyEnd = new ListNode(Integer.MIN_VALUE);
        ListNode dummyStart = new ListNode(Integer.MIN_VALUE);
        dummyStart.next = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
        }
        tempNode.next = dummyEnd;
        tempNode = head;
        while (tempNode.next != null) {
            while (!listNodeStack.isEmpty() && listNodeStack.peek().val == tempNode.val) {
                listNodeStack.peek().next = null;
            }
            tempNode = tempNode.next;
        }
        return head;
    }
}
