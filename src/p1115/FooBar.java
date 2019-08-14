package p1115;

import java.util.concurrent.CountDownLatch;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-14 09:29
 */
class FooBar {
    private int n;
    volatile int flip = 0;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.

            while (flip == 1) {
                Thread.sleep(0);
            }
            printFoo.run();
            synchronized (this) {
                flip = 1;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            while (flip == 0) {
                Thread.sleep(0);
            }
            printBar.run();
            synchronized (this) {

                flip = 0;
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(100);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new printFoobar(0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new printFoobar(1));
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

class printFoobar implements Runnable {

    int i = 0;

    printFoobar(int i) {
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