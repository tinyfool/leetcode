package CLRS;

public class Queue {

    int[] data;
    int head = 0;
    int tail = 0;
    Queue(int n) {

        data = new int[n];
    }

    void en(int x){

        data[tail] = x;
        if(tail==data.length-1) {
            tail = 0;
        }
        else
            tail++;
    }

    int de() {

        int x = data[head];
        if(head==data.length-1) {
            head = 0;
        }
        head++;
        return x;
    }

    public static void main(String[] args) {

        Queue q = new Queue(10);
        q.en(1);
        q.en(2);
        q.en(3);
        q.en(4);
        q.en(5);
        q.en(6);
        System.out.println(q.de());
        System.out.println(q.de());
        System.out.println(q.de());
        System.out.println(q.de());
        System.out.println(q.de());
        System.out.println(q.de());
        q.en(7);
        System.out.println(q.de());
    }
}
