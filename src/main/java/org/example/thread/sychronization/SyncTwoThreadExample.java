package org.example.thread.sychronization;

class Printer {
     void printNumbers(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(System.currentTimeMillis() +", "+threadName + " - " + i);
            synchronized(this){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }
}

public class SyncTwoThreadExample {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread t1 = new Thread(() -> printer.printNumbers("Thread-1"));
        Thread t2 = new Thread(() -> printer.printNumbers("Thread-2"));

        t1.start();
        t2.start();


        try { t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
