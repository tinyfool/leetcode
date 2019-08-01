package p0725;

import helper.ListNode;

import java.util.List;

//Runtime: 1 ms, faster than 11.59% of Java online submissions for Split Linked List in Parts.
//Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Split Linked List in Parts.

public class Solution {

    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode[] nodes = new ListNode[k];
        if(root==null)
            return nodes;
        int count = count(root);
        int eachpart = count/k;
        int remain = count%k;
        if (eachpart < 1) {
            eachpart = 1;
            remain = 0;
        }
        ListNode curr = root;
        int i = 0;
        int n = 1;

        nodes[0] = root;
        curr = root.next;
        while (curr!=null) {

            i++;
            if(n<=remain && i==eachpart+1 || n>remain && i==eachpart) {

                nodes[n] = curr;
                curr = curr.next;
                n++;
                i=0;
                continue;
            }
            curr = curr.next;
        }
        for(int j=0;j<k;j++) {
            if (j<=remain - 1 && remain>0)
                cut(nodes[j], eachpart + 1);
            else
                cut(nodes[j], eachpart );
        }
        return nodes;
    }

    private void cut(ListNode node,int k) {

        ListNode curr = node;
        int i = 0;
        while (curr!=null) {
            i++;
            if(i==k){
                curr.next = null;
                return;
            }
            curr = curr.next;
        }
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
        ListNode[] ret;

        node = ListNode.fromArray(new int[]{1,2,3});
        ret = solution.splitListToParts(node,5);
        for(ListNode aNode:ret) {
            if(aNode==null)
                System.out.print(" null,");
            else
                aNode.show();
        }

        System.out.println();

        node = ListNode.fromArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ret = solution.splitListToParts(node,3);
        for(ListNode aNode:ret) {
            if(aNode==null)
                System.out.print(" null,");
            else
                aNode.show();
        }
    }
}
