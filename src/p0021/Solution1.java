package p0021;

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newRoot = new ListNode(0);
        ListNode node = newRoot;
        while(l1!=null || l2!=null) {

            if (l1 == null) {
                node.next = l2;
                break;
            }
            if (l2 == null) {
                node.next = l1;
                break;
            }
            if (l1.val<=l2.val) {
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        return newRoot.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(5);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        Solution1 solution1 = new Solution1();
        ListNode newNode = solution1.mergeTwoLists(node1,node2);
        newNode.show();
    }
}

///     Runtime: 1 ms, faster than 82.57% of Java online submissions for Merge Two Sorted Lists.
//      Memory Usage: 37 MB, less than 97.90% of Java online submissions for Merge Two Sorted Lists.
