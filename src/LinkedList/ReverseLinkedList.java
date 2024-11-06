package LinkedList;

import util.ListNode;

import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        new ReverseLinkedList().reverseList(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4, new ListNode(5))))));
    }
    /**
     * Using Stack
     */
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
