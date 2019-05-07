package p0023;

class ListNode {

    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    void show() {

        ListNode node = this;
        while (node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

public class Solution1 {

    public ListNode mergeKLists(ListNode[] lists) {

        int p = 0;
        int r = lists.length-1;
        merge2left(lists,p,r);
        return lists[0];
    }

    void merge2left(ListNode[] lists,int p,int r) {

        if (p==r)
            return;
        if (p+1==r) {
            combine(lists,p);
            return;
        }
        int q = p/2;
        merge2left(lists,p,q);
        merge2left(lists,q+1,r);
    }

    void combine(ListNode[] list,int p) {
        ListNode newNode;
        ListNode left = list[p];
        ListNode right = list[p];
        while (left!=null || right!=null) {

//            if(left == null)
//                newNode.next =
            if (left.val<right.val) {

            }
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


