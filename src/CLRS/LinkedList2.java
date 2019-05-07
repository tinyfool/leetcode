package CLRS;


public class LinkedList2 {

    LinkedListNode nil = new LinkedListNode();

    LinkedListNode search(int k) {

        LinkedListNode x = nil.next;
        while (x!=null && x!=nil && x.key!=k)
            x = x.next;
        return x;
    }

    void insert(LinkedListNode x) {

        x.next = nil.next;
        if (nil.next!=null)
            nil.next.prev = x;
        nil.next = x;
        x.prev = nil;
    }

    void delete(LinkedListNode x) {

        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    public static void main(String[] args) {

        LinkedList2 ll = new LinkedList2();
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
