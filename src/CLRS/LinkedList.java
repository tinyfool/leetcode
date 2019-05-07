package CLRS;


public class LinkedList {

    LinkedListNode head;

    LinkedListNode search(int k) {
        LinkedListNode x = head;
        while (x!=null && x.key!=k)
            x = x.next;
        return x;
    }

    void insert(LinkedListNode x) {

        x.next = head;
        if (head!=null)
            head.prev = x;
        head = x;
        x.prev = null;
    }

    void delete(LinkedListNode x) {

        if (x.prev!=null)
            x.prev.next = x.next;
        else
            head = x.next;
        if (x.next!=null)
            x.next.prev = x.prev;
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        System.out.println(ll.search(25));
        LinkedListNode x = new LinkedListNode();
        x.key = 25;
        ll.insert(x);
        System.out.println(ll.search(25));
        x = new LinkedListNode();
        x.key = 15;
        ll.insert(x);
        System.out.println(ll.search(25));
        x = new LinkedListNode();
        x.key = 11;
        ll.insert(x);
        x = new LinkedListNode();
        x.key = 29;
        ll.insert(x);
        x = ll.search(15);
        ll.delete(x);
        System.out.println(ll.search(25));

    }
}
