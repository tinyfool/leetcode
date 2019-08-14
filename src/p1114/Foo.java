package p1114;

/**
 * Author: Haopeiqiang(Tinyfool)
 * Email: tinyfool@gmail.com
 * Date: 2019-08-14 09:17
 */

import java.util.concurrent.CountDownLatch;

class Foo {

    CountDownLatch latch2;
    CountDownLatch latch3;

    public Foo() {
        latch2 = new CountDownLatch(1);
        latch3 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {

        latch2.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        latch3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch3.await();

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String[] args) {

        Foo foo = new Foo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.second(new printNumber(2));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.first(new printNumber(1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.third(new printNumber(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class printNumber implements Runnable {

    int i = 0;

    printNumber(int id) {
        i = id;
    }

    @Override
    public void run() {
        System.out.print(i);
    }
}