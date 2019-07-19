package p0147;

import helper.ListNode;

import java.util.List;

//Runtime: 30 ms, faster than 63.10% of Java online submissions for Insertion Sort List.
//        Memory Usage: 38.2 MB, less than 47.28% of Java online submissions for Insertion Sort List.

class Solution1 {

  public ListNode insertionSortList(ListNode head) {

    ListNode current = head;
    ListNode next = null;
    ListNode dummy  = new ListNode(0);
    while (current!=null) {

      next = current.next;
      ListNode temp = dummy;
      while(temp.next!=null && temp.next.val<current.val) {
        temp = temp.next;
      }
      current.next = temp.next;
      temp.next = current;
      current = next;
    }
    return dummy.next;
  }


  public static void main(String[] argv) {

    ListNode node1 = new ListNode(6);
    node1.next = new ListNode(5);
    node1.next.next = new ListNode(3);
    node1.next.next.next = new ListNode(1);

    Solution1 s1 = new Solution1();
    ListNode node = s1.insertionSortList(node1);
    node.show();
  }

}

