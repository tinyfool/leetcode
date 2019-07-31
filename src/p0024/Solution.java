package p0024;

import helper.ListNode;

import java.util.List;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
//Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Swap Nodes in Pairs.

class Solution {

    public ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while(current!=null) {

            swap(current);
            if(current.next!=null)
                current = current.next.next;
            else
                break;
        }
        return dummy.next;
    }

    private void swap(ListNode node){

        //node.show();
        if(node.next==null)
            return;
        if(node.next.next==null)
            return;
        ListNode temp = node.next;
        node.next = node.next.next;
        temp.next = node.next.next;
        node.next.next = temp;
    }

    public static void main(String[] args){

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        Solution s = new Solution();
        node = s.swapPairs(node);
        node.show();
    }
}