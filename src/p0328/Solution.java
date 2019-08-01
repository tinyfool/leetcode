package p0328;

import helper.ListNode;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Odd Even Linked List.
//Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Odd Even Linked List.
public class Solution {

    public ListNode oddEvenList(ListNode head) {

        ListNode curr = head;
        int i = 0;
        ListNode d1 = new ListNode(0);
        ListNode d2 = new ListNode(0);
        ListNode f1 = d1;
        ListNode f2 = d2;
        while (curr!=null) {

            i++;
            if(i%2==1) {
                f1.next = curr;
                f1 = f1.next;
            }else {
                f2.next = curr;
                f2 = f2.next;
            }
            curr = curr.next;
        }
        f1.next = d2.next;
        return d1.next;
    }

}
