package p0142;

import helper.ListNode;

import java.util.HashSet;

//Runtime: 6 ms, faster than 19.68% of Java online submissions for Linked List Cycle II.
//Memory Usage: 35.2 MB, less than 14.79% of Java online submissions for Linked List Cycle II.

public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode curr = head;
        HashSet<ListNode> set = new HashSet<>();
        while (curr!=null) {

            if(curr.next==null)
                break;
            if(set.contains(curr.next)) {

                return curr.next;
            }
            set.add(curr);
            curr = curr.next;
        }
        return null;
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
        System.out.println(solution.detectCycle(node).val);
    }

}
