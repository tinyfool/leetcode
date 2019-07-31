package p0061;

import helper.ListNode;

import java.util.LinkedList;
import java.util.List;
//Runtime: 1 ms, faster than 29.69% of Java online submissions for Rotate List.
//Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Rotate List.

public class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head==null)
            return null;

        int n = count(head);
        if(k>n)
            k = k % n;

        if(k==n)
            return head;

        LinkedList<ListNode> queue = new LinkedList();
        ListNode current = head;
        ListNode end = null;
        while (current!=null) {
            queue.add(current);
            if(queue.size()>k+1)
                queue.removeFirst();
            end = current;
            current = current.next;
        }
        end.next = head;
        head = queue.getFirst().next;
        queue.getFirst().next = null;
        return head;
    }

    private int count(ListNode head) {

        int i = 0;
        ListNode current = head;
        while (current != null) {
            i++;
            current = current.next;
        }
        return i;
    }
    public static void main(String[] args){

        ListNode node = ListNode.fromArray(new int[]{1,2,3,4,5,});
        Solution solution = new Solution();
        node = solution.rotateRight(node,2);
        node.show();

        node = ListNode.fromArray(new int[]{0,1,2});
        node = solution.rotateRight(node,4);
        node.show();

    }
}
