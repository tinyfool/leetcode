package p0232;


import java.util.Stack;
//Runtime: 42 ms, faster than 80.55% of Java online submissions for Implement Queue using Stacks.
//Memory Usage: 34 MB, less than 14.71% of Java online submissions for Implement Queue using Stacks.
public class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {

        Stack<Integer> tempStack = new Stack<>();
        tempStack.push(x);
        tempStack.addAll(stack);
        stack = tempStack;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
