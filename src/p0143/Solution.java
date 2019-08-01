package p0143;

import helper.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

//Runtime: 6 ms, faster than 10.81% of Java online submissions for Reorder List.
//Memory Usage: 39.5 MB, less than 97.19% of Java online submissions for Reorder List.

public class Solution {

    public void reorderList(ListNode head) {

        if (head==null)
            return;
        int size = count(head);
        if(size<=2)
            return;

        int half = size/2;
        ListNode curr = head.next;
        int i = 0;
        ArrayList<ListNode> list = new ArrayList<>();
        Stack<ListNode> stack = new Stack<>();
        while (curr!=null) {

            i++;
            if(i<=half) {
                list.add(curr);
            }else{
                stack.push(curr);
            }
            curr = curr.next;
        }

        ListNode father = head;
        for(ListNode node2:list) {

            ListNode node;
            if(!stack.empty()) {
                node = stack.pop();
                father.next = node;
                father = father.next;
            }
            father.next = node2;
            father = father.next;
        }
        father.next = null;
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

    public static void main(String[] args) {

        ListNode node;
        Solution solution = new Solution();

        node = ListNode.fromArray(new int[]{1,2,3,4,5});
        solution.reorderList(node);
        node.show();

        node = ListNode.fromArray(new int[]{1,2,3,4});
        solution.reorderList(node);
        node.show();

    }
}
