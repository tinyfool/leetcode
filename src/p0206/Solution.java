package p0206;

import helper.ListNode;

import java.util.Stack;

//Runtime: 1 ms, faster than 6.17% of Java online submissions for Reverse Linked List.
//Memory Usage: 37.2 MB, less than 99.63% of Java online submissions for Reverse Linked List.

public class Solution {

    public ListNode reverseList(ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        ListNode dummy = new ListNode(0);
        ListNode f = dummy;
        while (curr!=null)  {

            stack.push(curr);
            curr = curr.next;
        }

        while (!stack.empty()) {

            f.next = stack.pop();
            f = f.next;
        }
        f.next = null;
        return dummy.next;
    }
    public static void main(String[] args){

        ListNode node = ListNode.fromArray(new int[]{1,2,3,4,5,6});
        Solution solution = new Solution();
        node = solution.reverseList(node);
        node.show();
    }

}
