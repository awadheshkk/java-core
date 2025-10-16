package org.example.thread.sychronization;

class Counter1 {
    private int count = 0;

    private int count1 = 0;

    private int count2 = 0;

    // synchronized method
     void increment() {
        System.out.println("count1:"+count1++);
        synchronized (this) {
            System.out.println("count2:"+count2++);
            count++;
        }
    }

    int getCount() {
        return count;
    }
}

public class WithSyncExample {
    public static void main(String[] args) throws InterruptedException {
        Counter1 counter = new Counter1();

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

