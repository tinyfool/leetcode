package p0023;

public class Solution2 {

    public ListNode mergeKLists(ListNode[] lists) {

        mergeK(lists,0,lists.length-1);
        return lists[0];
    }

    void mergeK(ListNode[] lists,int p,int r) {

        if (p<r) {

            int q = (p+r)/2;
            mergeK(lists,p,q);
            mergeK(lists,q+1,r);
            lists[p] = mergeTwoLists(lists[p],lists[q+1]);
        }
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

        ListNode[] input = new ListNode[]{null,node1,node2,node3};
        Solution2 solution1 = new Solution2();
        ListNode result = solution1.mergeKLists(input);

        if (result!=null)
            result.show();
    }
}


