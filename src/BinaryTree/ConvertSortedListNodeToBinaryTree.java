package BinaryTree;

import com.sun.source.tree.Tree;
import util.ListNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode#109
 */
public class ConvertSortedListNodeToBinaryTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head ==null)return null;
        List<Integer> values =new ArrayList<>();
        while(head!=null){
            values.add(head.val);
            head=head.next;
        }
        return sortedListToBSTUtil(values,0,values.size()-1);
    }

    private TreeNode sortedListToBSTUtil(List<Integer> values, int start, int end) {
        if(start>end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left=sortedListToBSTUtil(values,start,mid-1);
        root.right =sortedListToBSTUtil(values,mid+1,end);
        return root;
    }
}
