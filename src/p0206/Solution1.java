package p0206;

import helper.ListNode;

import java.util.Stack;
//Runtime: 25 ms, faster than 6.17% of Java online submissions for Reverse Linked List.
//Memory Usage: 37.3 MB, less than 99.59% of Java online submissions for Reverse Linked List.

public class Solution1 {

    public ListNode reverseList(ListNode head) {

        if(head==null)
            return head;
        return  moveEndtobefore(head);
    }

    public ListNode moveEndtobefore(ListNode node) {

        if(node.next==null)
            return node;
        ListNode current = node;
        ListNode newTop = null;
        while (current!=null){
            if(current.next.next==null){

                newTop = current.next;
                current.next = null;
                newTop.next = node;
                break;
            }
            current = current.next;
        }
        newTop.next = moveEndtobefore(newTop.next);
        return newTop;
    }
    
    public static void main(String[] args){

        ListNode node = ListNode.fromArray(new int[]{1,2,3,4,5,6});
        Solution1 solution = new Solution1();
        node = solution.reverseList(node);
        node.show();
    }
}
