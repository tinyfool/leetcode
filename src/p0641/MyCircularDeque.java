package p0641;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyCircularDeque {

    int[] data;
    int head = 0;
    int tail = 0;
    int maxSize;
    /** Initialize your data structure here. Set the size of the deque to be k. */

    public MyCircularDeque(){

        int k ;
        k=3;
        data = new int[k];
        maxSize = k;
    }


    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {

        if(!isFull()) {
            data[tail] = value;
            tail++;
            return true;
        }else
            return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {

        return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {

        if(!isEmpty()) {
            tail--;
            return true;
        }else
            return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {

        return 0;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return data[tail-1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {

        if(tail==head)
            return true;
        else
            return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if(tail-head >= maxSize)
            return true;
        else
            return false;
    }

    @Test
    public void testcase(){

        MyCircularDeque circularDeque = new MyCircularDeque();
        assertTrue(circularDeque.insertLast(1));
        assertTrue(circularDeque.insertLast(2));
        assertTrue(circularDeque.insertFront(3));
        assertTrue(circularDeque.insertFront(4));
        assertEquals(2,circularDeque.getRear());
        assertTrue(circularDeque.isFull());
        assertTrue(circularDeque.deleteLast());
        assertTrue(circularDeque.insertFront(4));
        assertEquals(4,circularDeque.getFront());
    }
}

