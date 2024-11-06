package LinkedList;

import util.ListNode;

import java.util.Stack;

/**
 * LEETCODE#86
 */
public class PartitionList {

    public static void main(String[] args) {
       ListNode head = new PartitionList().partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2,new ListNode(5, new ListNode(2)))))),3);;
    }
    public ListNode partition(ListNode head, int x) {
        Stack<ListNode> minNodeStack = new Stack<>();
        Stack<ListNode> maxNodeStack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                minNodeStack.add(temp);
            } else  {
                maxNodeStack.add(temp);
            }
            temp=temp.next;
        }
        ListNode poppedNode = null;
        ListNode intermediate = null;
        ListNode end = null;
        if(!minNodeStack.isEmpty()){
            intermediate = minNodeStack.peek();
            while (!minNodeStack.isEmpty()){
                poppedNode =minNodeStack.pop();
                poppedNode.next=end;
                end = poppedNode;
            }
            head =poppedNode;
        }
        end = null;poppedNode=null;
        while(!maxNodeStack.isEmpty()){
            poppedNode =maxNodeStack.pop();
            poppedNode.next=end;
            end = poppedNode;
        }
        if(intermediate!=null){
            intermediate.next = poppedNode;
        }
        else{
            head =poppedNode;
        }
        printLinkedListNode(head);
        return head;

    }
    public void printLinkedListNode(ListNode node){
        ListNode temp =node;
        while(temp!=null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
