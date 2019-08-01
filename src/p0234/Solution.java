package p0234;

import helper.ListNode;

import java.util.Stack;

//Runtime: 4 ms, faster than 14.73% of Java online submissions for Palindrome Linked List.
//Memory Usage: 40 MB, less than 99.88% of Java online submissions for Palindrome Linked List.

public class Solution {

    public boolean isPalindrome(ListNode head) {

        int len = count(head);
        int half = len/2;

        ListNode curr = head;
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while(curr!=null) {
            i++;
            if(i<=half)
                stack.push(curr.val);
            if(len%2==0 && i>half ||len%2==1 && i>half+1) {

                int val = stack.pop();
                if(val!=curr.val)
                    return false;
            }

            curr = curr.next;
        }

        return true;
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

        node = ListNode.fromArray(new int[]{1,2,2,3,1});
        System.out.println(solution.isPalindrome(node));
    }

}
