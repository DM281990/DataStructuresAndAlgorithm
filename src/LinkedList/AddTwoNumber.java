package LinkedList;

import util.ListNode;

import java.util.Stack;

/**
 * Leetcode#445
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        new AddTwoNumber().addTwoNumbers1(new ListNode(7,new ListNode(2,new ListNode(4,new ListNode(3)))),
                new ListNode(5,new ListNode(6,new ListNode(4))));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1=reverseList(l1);
        l2=reverseList(l2);
        ListNode node = new ListNode();
        ListNode head = node;
        int carry = 0;
        while (l1 != null && l2 != null) {
            head.next = new ListNode();
            head.next.val = l1.val + l2.val + carry;
            if (head.next.val > 9) {
                carry = head.next.val / 10;
                head.next.val = head.next.val % 10;
            } else {
                carry = 0;
            }
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null && carry!=0) {
            head.next = new ListNode(carry);
        } else {
            if (l1 == null) {
                while (l2 != null) {
                    head.next = new ListNode();
                    head.next.val = l2.val + carry;
                    if (head.next.val > 9) {
                        carry = head.next.val / 10;
                        head.next.val = head.next.val % 10;
                    } else {
                        carry = 0;
                    }
                    head = head.next;
                    l2 = l2.next;
                }
            }
            if (l2 == null) {
                while (l1 != null) {
                    head.next = new ListNode();
                    head.next.val = l1.val + carry;
                    if (head.next.val > 9) {
                        carry = head.next.val / 10;
                        head.next.val = head.next.val % 10;
                    } else {
                        carry = 0;
                    }
                    head = head.next;
                    l1 = l1.next;
                }
            }
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return reverseList(node.next);

    }
    public ListNode reverseList(ListNode head) {
        if(head==null ||head.next==null) {
            return head;
        }
        ListNode temp =null;
        ListNode temp1=head;
        ListNode temp2 = head.next.next;
        while(temp1!=null) {
            temp2=temp1.next;
            temp1.next=temp;
            temp =temp1;
            temp1=temp2;
        }
        return temp;
    }
    //Using Stack;
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<ListNode> l1s = new Stack<>();
        Stack<ListNode> l2s = new Stack<>();
        Stack<ListNode> nonEmpty = new Stack<>();

        while(l1!=null){l1s.push(l1);l1=l1.next;}
        while(l2!=null){l2s.push(l2);l2=l2.next;}
        ListNode rs=null ,prev = null;
        int carry =0;
        while(!l1s.isEmpty()&&!l2s.isEmpty()){
            rs=new ListNode();
            rs.val=l1s.pop().val+l2s.pop().val+carry;
            carry = rs.val/10;rs.val=rs.val%10;
            rs.next=prev;
            prev=rs;
        }
        nonEmpty = l1s.isEmpty()?l2s.isEmpty()?nonEmpty:l2s:l1s;
        while (!nonEmpty.isEmpty()){
            rs=new ListNode();
            rs.val=nonEmpty.pop().val+carry;
            carry = rs.val/10;rs.val=rs.val%10;
            rs.next=prev;
            prev=rs;
        }
        if(carry!=0){
            rs=new ListNode();
            rs.next=prev;
            rs.val=carry;
        }
        return rs;
    }
}
