package LinkedList;

import util.ListNode;

import java.util.Stack;

/**
 * Leetcode#143
 */
public class ReorderList {
    public static void main(String[] args) {
        new ReorderList().reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5))))));
    }

    public void reorderList(ListNode head) {
        Stack<ListNode> stackNode = new Stack<>();
        if (head ==null ||head.next == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode temp = slow.next;
        slow.next =null;
        ListNode head2  = reverseList(temp);
        ListNode head1 =  head;
        temp =new ListNode(Integer.MIN_VALUE);
        head = temp;
        while(head1!=null && head2!=null){
            temp.next =head1;
            head1=head1.next;
            temp = temp.next;
            temp.next =head2;
            head2=head2.next;
            temp = temp.next;
        }
        while (head1!=null){
            temp.next = head1;
            head1 =head1.next;
            temp = temp.next;
        }
        while (head2!=null){
            temp.next = head2;
            head2 =head2.next;
            temp = temp.next;
        }
        head = head.next;
    }
    public ListNode reverseList(ListNode head){
        Stack<ListNode> listNodeStack = new Stack<>();
        if(head == null || head.next ==null){
            return head;
        }
        ListNode temp = head;
        while(temp!=null){
            listNodeStack.push(temp);
            temp=temp.next;
        }
        ListNode poppedNode = null;
        ListNode dummyStart = new ListNode(Integer.MIN_VALUE);
        dummyStart.next = listNodeStack.peek();
        temp =dummyStart;
        while (!listNodeStack.isEmpty()){
            poppedNode = listNodeStack.pop();
            temp.next =poppedNode;
            temp= poppedNode;
        }
        poppedNode.next =null;
        head =dummyStart.next;
        dummyStart.next =null;
        return head;

    }

}
