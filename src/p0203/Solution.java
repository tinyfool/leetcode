package p0203;

import helper.ListNode;
//Runtime: 1 ms, faster than 98.54% of Java online submissions for Remove Linked List Elements.
//Memory Usage: 39.5 MB, less than 100.00% of Java online submissions for Remove Linked List Elements.

public class Solution {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while (curr!=null) {
            if(curr.val==val) {
                prev.next = curr.next;
                curr = curr.next;
                continue;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        ListNode node;
        Solution solution = new Solution();

        node = ListNode.fromArray(new int[]{1,1});
        node = solution.removeElements(node,1);
        if(node!=null)
            node.show();
    }
}
