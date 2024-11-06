package LinkedList;

import util.ListNode;

public class SwappingNodesLinkedList {
    public static void main(String[] args) {
        new SwappingNodesLinkedList().swapNodes(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5))))),3);

    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode n1 = null, n2 = null;
        for (var p = head; p != null; p = p.next) {
            n2 = n2 == null ? null : n2.next;
            if (--k == 0) {
                n1 = p;
                n2 = head;
            }
        }
        // The problem description specifically asks to swap values, not nodes themselves.
        var tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        return head;
    }
}
