package org.example.thread.sychronization;
// Class level lock
class Printer1 {
    static synchronized void printNumbers(String threadName) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " - " + i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

     static synchronized void printNumbers1(String threadName) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " + " + i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void printNumbers2(String threadName) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " + " + i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class StaticSyncExample {
    public static void main(String[] args) {
        Printer1 p = new Printer1();
        Thread t1 = new Thread(() -> Printer1.printNumbers("Thread-A"));
        Thread t2 = new Thread(() -> Printer1.printNumbers1("Thread-B"));
        Thread t3 = new Thread(() -> p.printNumbers2("Thread-C"));

        t1.start();
        t2.start();
        t3.start();
    }
}
