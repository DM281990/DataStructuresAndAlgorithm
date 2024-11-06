package LinkedList;

import util.ListNode;

/**
 * Leetcode#141
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        new LinkedListCycle().hasCycle(new ListNode(1));
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    /**
     * Leetcode#142
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasCycle =false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle =true;
                break;
            }
        }
        if(hasCycle){
            ListNode start = head;
            ListNode meetingPoint = slow;
            while(start != meetingPoint){
                start = start.next;
                meetingPoint = meetingPoint.next;
            }
            return  meetingPoint;
        }
        return null;
    }
}
