package LinkedList;

import util.ListNode;

/**
 * Leetcode#61
 */
public class RotateList {
    public static void main(String[] args) {
        new RotateList().rotateRight(new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5))))),2);
    }
    public ListNode rotateRight(ListNode head, int k) {
        int size =0;
        ListNode temp = head;
        ListNode end=temp;
        while(temp!=null){
            size++;
            end=temp;
            temp=temp.next;
        }
        if(size==0 || size==1){
            return head;
        }
        k = k%size;
        if(k==0){
            return head;
        }
        temp=head;
        ListNode prev =head;
        for(int i=0;i<k;i++){
            temp = temp.next;
        }
        while(temp.next!=null){
            prev=prev.next;
            temp=temp.next;
        }
        end.next=head;
        head=prev.next;
        prev.next=null;
        return head;
    }
}
