package org.example.thread;

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " running: " + i);
            try {
                Thread.sleep(500); // Timed Waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExample2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable(), "Worker-1");
        Thread t2 = new Thread(new MyRunnable(), "Worker-2");

        t1.start(); // Runnable
        t2.start();

        System.out.println("Main thread exiting...");
    }
}

