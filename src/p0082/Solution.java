package p0082;
import helper.ListNode;

import java.util.HashMap;
//Runtime: 3 ms, faster than 6.30% of Java online submissions for Remove Duplicates from Sorted List II.
//Memory Usage: 35.9 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List II.
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null)
            return null;

        HashMap<Integer,Integer> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        ListNode father = dummy;
        ListNode curr = head;
        while (curr!=null) {

            map.put(curr.val,map.getOrDefault(curr.val,0)+1);
            curr = curr.next;
        }

        curr = head;
        while (curr!=null) {
            if(map.get(curr.val)==1) {
                father.next = curr;
                father = curr;
            }
            curr = curr.next;
        }
        father.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {


        ListNode node;
        Solution solution = new Solution();

        node = ListNode.fromArray(new int[]{1,2,3,3,4,4,5});
        node = solution.deleteDuplicates(node);
        node.show();

        node = ListNode.fromArray(new int[]{1,1,1,2,3});
        node = solution.deleteDuplicates(node);
        node.show();
    }
}
