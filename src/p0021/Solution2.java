package p0021;


public class Solution2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        if(l1.val<=l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        Solution2 solution2 = new Solution2();
        ListNode newNode = solution2.mergeTwoLists(node1,node2);
        newNode.show();
    }
}

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
//    Memory Usage: 38.4 MB, less than 83.35% of Java online submissions for Merge Two Sorted Lists.
