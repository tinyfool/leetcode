import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Solution002 {

    public static void main(String [] args) {

        Solution002 solution = new Solution002();

        ListNode node = new ListNode(2);
        ListNode l1 = node;
        ListNode o1 = node;

        node = new ListNode(4);
        o1.next = node;
        o1 = node;

        node = new ListNode(3);
        o1.next = node;

        System.out.println(l1);

        node = new ListNode(5);
        ListNode l2 = node;
        ListNode o2 = node;

        node = new ListNode(6);
        o2.next = node;
        o2 = node;

//        node = new ListNode(4);
//        o2.next = node;

        System.out.println(l2);

        node = solution.addTwoNumbers(l1,l2);
        System.out.println(node);
    }

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
}

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
            sb.append(node.val).append(" -> ");
        }
        return sb.toString();
    }
}
