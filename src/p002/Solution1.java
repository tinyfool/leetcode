package p002;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.val).append(" -> ");

        ListNode node = this;
        while(node.next!=null) {

            node = node.next;
            sb.append(node.val);

            if(node.next!=null) {
                sb.append(" -> ");
            }
        }
        return sb.toString();
    }
}

public class Solution1 {



    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int nVal = l1.val+l2.val;
        int add = 0;
        if(nVal>=10) {

            nVal = nVal - 10;
            add = 1;
        }else {

            add = 0;
        }
        ListNode newNode = new ListNode(nVal);
        ListNode ret = newNode;
        ListNode oldNode = null;

        while (true) {

            oldNode = newNode;
            if(l1.next==null && l2.next==null){

                if(add ==1) {
                    newNode = new ListNode(1);
                    oldNode.next = newNode;
                }
                break;
            }
            int v1 = 0;
            int v2 = 0;
            if(l1.next != null) {
                l1 = l1.next;
                v1 = l1.val;
            }
            if(l2.next != null) {
                l2 = l2.next;
                v2 = l2.val;
            }
            nVal = v1+v2+add;
            if(nVal>=10) {

                nVal = nVal - 10;
                add = 1;
            }else {

                add = 0;
            }
            newNode = new ListNode(nVal);
            oldNode.next = newNode;
        }
        return ret;
    }

    public static void main(String [] args) {

        Solution1 solution = new Solution1();

        int[] num1 = new int[]{2,4,3};
        int[] num2 = new int[]{5,6,4};

        ListNode n1 = new ListNode(0);
        ListNode node = n1;

        for(int i=0;i<num1.length;i++) {
            node.val = num1[i];
            if(i<num1.length-1) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }
        System.out.println(n1);

        ListNode n2 = new ListNode(0);
        node = n2;
        for(int i=0;i<num2.length;i++) {
            node.val = num2[i];
            if(i<num1.length-1) {
                node.next = new ListNode(0);
                node = node.next;
            }
        }
        System.out.println(n2);


        node = solution.addTwoNumbers(n1,n2);
        System.out.println(node);
    }
}

