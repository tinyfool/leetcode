package p0876;

import helper.ListNode;

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
//Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Middle of the Linked List.

class Solution {

    public ListNode middleNode(ListNode head) {

        int n = count(head);
        int half = n/2;
        ListNode curr = head;
        int i = 0;
        while(curr!=null) {

            if(i==half)
                return curr;
            curr = curr.next;
            i++;
        }
        return head;
    }

    private int count(ListNode head) {

        int i = 0;
        ListNode current = head;
        while (current != null) {
            i++;
            current = current.next;
        }
        return i;
    }
}