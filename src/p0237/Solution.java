package p0237;

import helper.ListNode;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
//Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Delete Node in a Linked List.
public class Solution {

    void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }


}
