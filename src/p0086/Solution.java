package p0086;

import helper.ListNode;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
//Memory Usage: 36 MB, less than 100.00% of Java online submissions for Partition List.
public class Solution {

    public ListNode partition(ListNode head, int x) {

        if(head == null)
            return null;

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode f1 = dummy1;
        ListNode f2 = dummy2;
        ListNode curr = head;
        while (curr!=null) {

            if(curr.val<x) {

                f1.next = curr;
                f1 = curr;
            }else {
                f2.next = curr;
                f2 = curr;

            }
            curr = curr.next;
        }
        f1.next = dummy2.next;
        f2.next = null;
        return dummy1.next;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode node = ListNode.fromArray(new int[]{1,4,3,2,5,2});
        solution.partition(node,3);
        node.show();
    }
}
