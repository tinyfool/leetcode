package p0023;

public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0)
            return null;
        ListNode result = lists[0];
        for(int i = 1;i<lists.length;i++) {
            result = mergeTwoLists(result,lists[i]);
        }
        return result;
    }


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

//        Input:
//        [
//          1->4->5,
//          1->3->4,
//          2->6
//        ]
//        Output: 1->1->2->3->4->4->5->6

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode node3 = new ListNode(2);
        node3.next = new ListNode(6);

        ListNode[] input = new ListNode[]{node1,node2,node3};
        Solution1 solution1 = new Solution1();
        ListNode result = solution1.mergeKLists(input);

        if (result!=null)
            result.show();
    }
}


