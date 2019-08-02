package p0707;


//Runtime: 54 ms, faster than 58.73% of Java online submissions for Design Linked List.
//Memory Usage: 46.6 MB, less than 35.30% of Java online submissions for Design Linked List.

public class MyLinkedList {

    /** Initialize your data structure here. */
    Node head;
    public MyLinkedList() {

        head = new Node(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        Node curr = head.next;
        int i = 0;
        while (curr!=null) {
            if(i==index)
                return curr.val;
            curr = curr.next;
            i++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        Node temp = head.next;
        head.next = new Node(val);
        head.next.next = temp;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        Node curr = head.next;
        Node end = head;
        while (curr!=null) {
            end = curr;
            curr = curr.next;
        }
        end.next = new Node(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {

        if(index<=0){
            addAtHead(val);
            return;
        }
        Node curr = head;
        int i = 0;
        while (curr!=null) {
            i++;
            if(i==index+1) {

                Node temp = curr.next;
                curr.next = new Node(val);
                curr.next.next = temp;
                break;
            }
            curr = curr.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        Node curr = head.next;
        int i = 0;
        Node prev = head;
        while (curr!=null) {
            if(i==index) {

                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
            i++;
        }
    }
}
class Node {

    int val;
    Node next;
    Node(int aVal) {
        val = aVal;
    }
}
