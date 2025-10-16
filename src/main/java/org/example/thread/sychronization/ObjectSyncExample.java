package org.example.thread.sychronization;
// Object level lock
class Printer2 {
     synchronized void printNumbers(String threadName) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(threadName + " - " + i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

      synchronized void printNumbers1(String threadName) {
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

public class ObjectSyncExample {
    public static void main(String[] args) {
        Printer2 p = new Printer2();
        Thread t1 = new Thread(() -> p.printNumbers("Thread-A"));
        Printer2 p1 = new Printer2();
        Thread t2 = new Thread(() -> p1.printNumbers1("Thread-B"));
        Thread t3 = new Thread(() -> p.printNumbers2("Thread-C"));

        t1.start();
        t2.start();
        t3.start();
    }
}
