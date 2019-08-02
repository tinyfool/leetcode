package p1019;
import helper.ListNode;

import java.util.ArrayList;
//Runtime: 1057 ms, faster than 17.09% of Java online submissions for Next Greater Node In Linked List.
//Memory Usage: 39.8 MB, less than 97.27% of Java online submissions for Next Greater Node In Linked List.

public class Solution {

    public int[] nextLargerNodes(ListNode head) {

        ArrayList<Integer> list = new ArrayList<>();
        ListNode curr = head;
        while (curr!=null) {

            list.add(nextLarge(curr));
            curr = curr.next;
        }
        int[] ret = new int[list.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = list.get(i).intValue();
        }
        return ret;
    }

    private int nextLarge(ListNode head) {

        ListNode curr = head;
        int val = head.val;
        while (curr!=null) {

            if(curr.val>val)
                return curr.val;
            curr = curr.next;
        }
        return 0;
    }
}
