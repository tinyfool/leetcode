package p0083;

import helper.ListNode;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
//Memory Usage: 36 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List.

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null)
            return null;

        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){

            if(prev!=null){

                if(prev.val == curr.val) {
                    prev.next = curr.next;
                    curr = curr.next;
                    continue;
                }
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }


    public static void main(String[] args) {


        ListNode node;
        Solution solution = new Solution();

        node = ListNode.fromArray(new int[]{1,1,2});
        node = solution.deleteDuplicates(node);
        node.show();

        node = ListNode.fromArray(new int[]{1,1,2,3,3});
        node = solution.deleteDuplicates(node);
        node.show();


        node = ListNode.fromArray(new int[]{1,1,1});
        node = solution.deleteDuplicates(node);
        node.show();

    }
}
