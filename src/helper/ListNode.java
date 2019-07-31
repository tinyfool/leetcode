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
            System.out.print(node.val);
            System.out.print("->");
            node = node.next;
        }
        System.out.println();
    }
}
