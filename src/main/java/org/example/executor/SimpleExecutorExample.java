package org.example.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SimpleExecutorExample {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();

        executor.execute(() -> {
            System.out.println("Task executed by: " + Thread.currentThread().getName());
        });
    }
}
