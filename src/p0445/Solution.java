package p0445;

import helper.ListNode;
//Runtime: 3 ms, faster than 68.69% of Java online submissions for Add Two Numbers II.
//Memory Usage: 45.1 MB, less than 69.55% of Java online submissions for Add Two Numbers II.

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode result = addReverseTwoNumbers(l1,l2);
        result = reverseList(result);
        return result;
    }


    public ListNode reverseList(ListNode head) {

        if(head==null)
            return head;

        return  moveEndtobefore(head);
    }

    public ListNode moveEndtobefore(ListNode node) {

        if(node.next==null)
            return node;
        ListNode current = node;
        ListNode newTop = null;
        while (current!=null){
            if(current.next.next==null){

                newTop = current.next;
                current.next = null;
                newTop.next = node;
                break;
            }
            current = current.next;
        }
        newTop.next = moveEndtobefore(newTop.next);
        return newTop;
    }

    public ListNode addReverseTwoNumbers(ListNode l1, ListNode l2) {

        //初始化结果节点
        int nVal = l1.val+l2.val;
        int add = 0;
        if(nVal>=10) {

            nVal = nVal - 10;
            add = 1;
        }
        ListNode newNode = new ListNode(nVal);
        ListNode ret = newNode;
        ListNode oldNode = null;

        while (true) {

            oldNode = newNode;


            if(l1.next==null && l2.next==null){ //如果都没有下一个节点则退出

                if(add ==1) {
                    newNode = new ListNode(1);
                    oldNode.next = newNode;
                }
                break;
            }
            int v1 = 0;
            int v2 = 0;
            if(l1.next != null) { //如果还有l1
                l1 = l1.next;
                v1 = l1.val;
            }
            if(l2.next != null) { //如果还有l2
                l2 = l2.next;
                v2 = l2.val;
            }
            nVal = v1+v2+add;
            if(nVal>=10) {     //如果有进位则add为1

                nVal = nVal - 10;
                add = 1;
            }else
                add = 0;
            newNode = new ListNode(nVal);
            oldNode.next = newNode;
        }
        return ret;
    }
}
