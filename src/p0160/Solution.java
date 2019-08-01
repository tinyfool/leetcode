package p0160;

import helper.ListNode;

import java.util.HashSet;
//Runtime: 7 ms, faster than 21.64% of Java online submissions for Intersection of Two Linked Lists.
//Memory Usage: 39.7 MB, less than 14.11% of Java online submissions for Intersection of Two Linked Lists.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr!=null){

            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr!=null){

            if(set.contains(curr))
                return curr;
            curr = curr.next;
        }
        return null;
    }
}