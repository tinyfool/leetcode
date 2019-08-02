package p0707;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void test1() {

        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        assertEquals(2, list.get(1));
        list.deleteAtIndex(1);
        assertEquals(3, list.get(1));
    }

    @Test
    void test2() {

        MyLinkedList list;
        list = new MyLinkedList();
        list.addAtHead(5);
        list.addAtHead(2);
        list.deleteAtIndex(1);
        list.addAtIndex(1, 9);
        list.addAtHead(4);
        list.addAtHead(9);
        list.addAtHead(8);
        assertEquals(2, list.get(3));
        list.addAtTail(1);
        list.addAtIndex(3, 6);
        list.addAtHead(3);
    }

    @Test
    void test3() {

        MyLinkedList list;
        list = new MyLinkedList();
        list.addAtIndex(-1, 0);
        assertEquals(0, list.get(-1));
        list.deleteAtIndex(-1);
    }

}