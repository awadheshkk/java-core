package org.example.thread;

class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(1000); // Timed Waiting state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished execution.");
    }
}

public class ThreadExample1 {
    public static void main(String[] args) {
//        MyThread t1 = new MyThread();   // New state
//        t1.start();
//
//
//        MyThread t2 = new MyThread();   // New state
//        t2.start();
//
//        MyThread t3 = new MyThread();   // New state
//        t3.start();

        MyThread t1 = new MyThread();   // New state
        MyThread t2 = new MyThread();   // New state
        MyThread t3 = new MyThread();   // New state
        try {
            t1.join();
            t2.join();
            t3.join();
        }catch(InterruptedException e){

        }
        t1.start();
        t2.start();
        t3.start();


//        Main thread running...
//        Thread-2 - Count: 1
//        Thread-1 - Count: 1
//        Thread-0 - Count: 1
//        Thread-2 - Count: 2
//        Thread-1 - Count: 2
//        Thread-0 - Count: 2
//        Thread-2 - Count: 3
//        Thread-1 - Count: 3
//        Thread-0 - Count: 3
//        Thread-2 finished execution.
//        Thread-0 finished execution.
//        Thread-1 finished execution.




        // Runnable → Running
        System.out.println("Main thread running...");
    }
}
