package p1115;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-14 09:29
 */
class FooBar2 {
    private int n;

    public FooBar2(int n) {
        this.n = n;
    }
    Object lock1 = new Object();
    volatile int flip = 0;
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.

            synchronized (lock1) {
                while (flip==1) {
                    lock1.wait();
                }
                printFoo.run();
                flip=1;
                lock1.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized (lock1) {
                while (flip==0)
                    lock1.wait();
                printBar.run();
                flip=0;
                lock1.notify();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FooBar2 fooBar = new FooBar2(5);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new printFoobar2(0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new printFoobar2(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}

class printFoobar2 implements Runnable {

    int i = 0;

    printFoobar2(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        if (i == 0)
            System.out.print("foo");
        else
            System.out.print("bar");
    }
}