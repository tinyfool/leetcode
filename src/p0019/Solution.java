package p0019;

import helper.ListNode;

import java.util.List;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
//        Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Remove Nth Node From End of List.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode current = head;
        int i = 0;
        while (current!=null){
            i++;
            current=current.next;
        }


        if(i==1 && n==1)
            return null;
        int x = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        current = dummy;

        while (current!=null){
            if(x>=i-n) {
                if(current.next!=null) {
                    current.next = current.next.next;
                    break;
                }
            }
            current = current.next;
            x++;
        }
        return dummy.next;
    }


    public static void main(String[] args) {

        Solution s = new Solution();
        ListNode node;

        node = new ListNode(1);
        node = s.removeNthFromEnd(node,1);
        if (node!=null)
            node.show();


        node = new ListNode(1);
        node.next = new ListNode(2);
        node = s.removeNthFromEnd(node,2);
        node.show();

        node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node = s.removeNthFromEnd(node,3);
        node.show();
    }
}