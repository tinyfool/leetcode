package p0225;

import java.util.LinkedList;
import java.util.Queue;

//Runtime: 41 ms, faster than 99.56% of Java online submissions for Implement Stack using Queues.
//Memory Usage: 33.9 MB, less than 92.30% of Java online submissions for Implement Stack using Queues.
public class MyStack {

    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Queue<Integer> tempQ = new LinkedList();
        tempQ.add(x);
        tempQ.addAll(queue);
        queue = tempQ;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
