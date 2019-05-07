package p0021;

public class ListNode {

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
