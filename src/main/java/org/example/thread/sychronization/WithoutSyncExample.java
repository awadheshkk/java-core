package org.example.thread.sychronization;

class Counter {
    private int count = 0;

    void increment() {
        count++;  // not synchronized

    }

    int getCount() {
        return count;
    }
}

public class WithoutSyncExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + ":" + counter.getCount());
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + ":" + counter.getCount());
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}

