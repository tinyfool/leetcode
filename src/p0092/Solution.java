package p0092;

import helper.ListNode;

import java.util.Stack;
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
//Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Reverse Linked List II.
class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head==null)
            return null;
        if(m==1 && n==1)
            return head;
        int i = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode between=null;
        ListNode before= dummy;
        ListNode end=null;
        while(curr!=null) {
            i++;
            if(i==m-1)
                before = curr;
            if(i==m)
                between = curr;
            if(i==n) {
                ListNode betweenEnd;
                betweenEnd = curr;
                end = curr.next;
                betweenEnd.next = null;
                break;
            }
            curr = curr.next;
        }
        before.next =reverseList(between);
        between.next = end;
        return dummy.next;
    }

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

    public static void main(String[] args) {

        ListNode node = ListNode.fromArray(new int[]{1,2,3,4,5,});
        Solution solution = new Solution();

        node = solution.reverseBetween(node,2,4);
        node.show();

        node = ListNode.fromArray(new int[]{3,5,});
        node = solution.reverseBetween(node,1,2);
        node.show();

    }
}