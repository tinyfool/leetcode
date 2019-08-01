package p0817;

import helper.ListNode;
import java.util.HashSet;

//Runtime: 6 ms, faster than 96.65% of Java online submissions for Linked List Components.
//Memory Usage: 40.6 MB, less than 85.71% of Java online submissions for Linked List Components.

public class Solution {

    public int numComponents(ListNode head, int[] G) {

        HashSet<Integer> set = new HashSet<>();
        for(int g:G) {

            set.add(g);
        }
        ListNode curr = head;
        int i = 0;
        int inSet = 0;
        while (curr!=null) {

            if(set.contains(curr.val)) {
                if(inSet==0) {
                    inSet = 1;
                    i++;
                }
            }else if(inSet==1){

                inSet = 0;
            }
            curr = curr.next;
        }
        return i;
    }

    public static void main(String[] args) {

        ListNode node;
        int[] G;
        Solution solution = new Solution();

        node = ListNode.fromArray(new int[]{0,1,2,3,4});
        G = new int[]{0,3,1,4};
        System.out.println(solution.numComponents(node,G));

        node = ListNode.fromArray(new int[]{3,4,0,2,1});
        G = new int[]{4};
        System.out.println(solution.numComponents(node,G));
    }
}
