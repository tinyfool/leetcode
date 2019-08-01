package p0430;
import helper.Node;

//Runtime: 1 ms, faster than 15.13% of Java online submissions for Flatten a Multilevel Doubly Linked List.
//Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Flatten a Multilevel Doubly Linked List.

public class Solution {

    public Node flatten(Node head) {

        Node curr = head;
        while (curr!=null) {

            if(curr.child!=null) {

                Node node = flatten(curr.child);
                Node temp = curr.next;
                curr.child = null;
                Node end = end(node);
                if(end!=null) {
                    end.next = temp;
                    if(temp!=null)
                        end.next.prev = end;
                    }
                curr.next = node;
                node.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    private Node end(Node head) {

        Node curr = head;
        Node last = null;
        while (curr != null) {
            last = curr;
            curr = curr.next;
        }
        return last;
    }

    public static void main(String[]args) {

        Node node = new Node(1,null,null,null);
        node.next = new Node(2,node,null,null);
        node.next.next = new Node(3,node.next,null,null);
        node.next.child = new Node(4,null,null,null);
        Solution solution = new Solution();
        node = solution.flatten(node);
        System.out.println(node);
    }
}
