package helper;

import java.awt.*;

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
            if(node.next!=null)
                System.out.print("->");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode fromArray(int[] array){

        ListNode dummy = new ListNode(0);
        ListNode father = dummy;
        for(int number:array) {
            father.next = new ListNode(number);
            father = father.next;
        }
        return dummy.next;
    }
}
