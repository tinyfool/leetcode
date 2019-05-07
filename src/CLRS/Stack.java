package CLRS;

public class Stack {
    int top = -1;
    int[] data;

    Stack(int n) {

        data = new int[n];
    }

    boolean empty() {
        if(top==-1)
            return true;
        else
            return false;
    }

    void push(int x) {

        top++;
        data[top]=x;
    }

    int pop() throws Exception {

        if (empty())
            throw new Exception("Stack under flow");
        top--;
        return data[top+1];
    }

    public static void main(String[] args) throws  Exception {

        Stack s = new Stack(10);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());

        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
