package LinkedList;

import util.ListNode;

/**
 * LeetCode19
 */
public class NthNodeFormEnd {
    public static void main(String[] args) {
        new NthNodeFormEnd().removeNthFromEnd(new ListNode(
                1,
                new ListNode(2/*,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))*/)),1);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
