package p0141;

import helper.ListNode;

import java.util.HashSet;

//Runtime: 5 ms, faster than 9.16% of Java online submissions for Linked List Cycle.
//Memory Usage: 38.7 MB, less than 42.92% of Java online submissions for Linked List Cycle.

public class Solution {

    public boolean hasCycle(ListNode head) {

        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();
        while (curr!=null) {

            if(curr.next==null)
                break;
            if(set.contains(curr.next)) {

                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {

        ListNode node = ListNode.fromArray(new int[]{3,2,0,-41});
        ListNode curr = node;
        while (curr!=null) {
            if(curr.next == null)
                break;
            curr = curr.next;
        }
        curr.next = node.next;

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(node));
    }
}
