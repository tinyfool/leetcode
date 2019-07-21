package p0155;

import java.util.PriorityQueue;
//50ms
public class MinStack {

    /** initialize your data structure here. */
    int[] data = new int[10240];
    int top = -1;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public MinStack() {

    }

    public void push(int x) {
        top++;
        data[top] = x;
        queue.add(x);
    }

    public void pop() {

        queue.remove(data[top]);
        top--;
    }

    public int top() {

        return data[top];
    }

    public int getMin() {

        return queue.peek();
    }
}
