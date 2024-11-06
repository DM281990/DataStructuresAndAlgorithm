package LinkedList;

import util.ListNode;

import java.util.Stack;

/**
 * LeetCode #148
 */
public class SortList {

    public static void main(String[] args) {
        new SortList().sortList(new ListNode(5,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1))))));
    }

    /**
     * TLE: USing Stack
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        Stack<ListNode> listNodeStack1 =new Stack<>();
        Stack<ListNode> listNodeStack2 =new Stack<>();
        if( head ==null || head.next ==null){
            return head;
        }
        ListNode temp = head;
        while (temp!=null){
            while (!listNodeStack1.isEmpty() && listNodeStack1.peek().val>temp.val){
                listNodeStack2.push(listNodeStack1.pop());
            }
            listNodeStack1.push(temp);
            while (!listNodeStack2.isEmpty()){
                listNodeStack1.push(listNodeStack2.pop());
            }
            temp = temp.next;
        }
        ListNode head1 = null;
        ListNode poppedNode = null;
        while(!listNodeStack1.isEmpty()){
            poppedNode = listNodeStack1.pop();
            poppedNode.next=head1;
            head1 = poppedNode;
        }
        return head1;
    }

    /**
     * DivideAnd Conquer MERGE SORT
     */
    // Sort the linked list
    public ListNode sortList1(ListNode head) {
        return mergeSort(head);
    }
    // Merge sort algorithm
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Find the middle and split the list
        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null; // Split the list into two halves
        ListNode left = head;

        // Recursively sort both halves
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge both sorted halves
        return merge(left, right);
    }

    public ListNode findMiddle(ListNode head) {
        // Initialize fast as head.next to find middle properly
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; // Move fast pointer by two steps
        }
        return slow;
    }

    // Merge two sorted lists
    public ListNode merge(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (leftHead != null && rightHead != null) {
            if (leftHead.val < rightHead.val) {
                temp.next = leftHead;
                leftHead = leftHead.next;
            } else {
                temp.next = rightHead;
                rightHead = rightHead.next;
            }
            temp = temp.next; // Move the temp pointer
        }
        // If any elements left in leftHead or rightHead, append them
        while (leftHead != null) {
            temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next; // Move the temp pointer
        }
        while (rightHead != null) {
            temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next; // Move the temp pointer
        }
        return dummy.next; // Return the head of the merged list
    }




}
