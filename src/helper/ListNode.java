package helper;

public class ListNode {

    public int val;
    public ListNode next;
    
    public ListNode(int x) {
        val = x;
    }

    public void show() {

        ListNode node = this;
        while (node!=null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
