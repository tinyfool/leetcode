package p0025;

import helper.ListNode;

import java.util.List;
import java.util.Stack;
//Runtime: 3 ms, faster than 7.33% of Java online submissions for Reverse Nodes in k-Group.
//Memory Usage: 39.1 MB, less than 16.83% of Java online submissions for Reverse Nodes in k-Group.
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        ListNode current = head;
        Stack<ListNode> stack = new Stack();
        ListNode temp = dummy;
        while (current!=null) {

            stack.push(current);
            current = current.next;

            if(stack.size()==k){
                ListNode node= reverseList(stack);
                temp.next = node;
                temp = end(temp);
            }

        }

        if (stack.size()>0){

            ListNode father = end(temp);
            for(ListNode node:stack) {
                father.next = node;
                father = father.next;
            }
        }
        return dummy.next;
    }

    ListNode end(ListNode node) {

        ListNode current = node;
        ListNode end = null;
        while(current!=null) {

            end = current;
            current=current.next;
        }
        return end;
    }
    ListNode reverseList(Stack<ListNode> stack) {

        ListNode dummy = new ListNode(0);
        ListNode fatcher = dummy;
        while (!stack.empty()) {
            fatcher.next = stack.pop();
            fatcher = fatcher.next;
        }
        fatcher.next = null;
        return dummy.next;
    }
    public static void main(String[] args) {

        ListNode node;

        Solution s = new Solution();

        node = ListNode.fromArray(new int[]{1,2,3,4,5});
        node = s.reverseKGroup(node,2);
        node.show();

        node = ListNode.fromArray(new int[]{1,2,3,4,5});
        node = s.reverseKGroup(node,3);
        node.show();
    }
}