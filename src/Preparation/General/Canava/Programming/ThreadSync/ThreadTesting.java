package Preparation.General.Canava.Programming.ThreadSync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTesting {
    public static void main(String[] args) {
        ExecutorService test = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            test.submit(()-> {
                System.out.println(finalI + java.lang.Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        SynchronizedCounter test1 = new SynchronizedCounter();
        SynchronizedCounter counter = new SynchronizedCounter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        java.lang.Thread t1 = new java.lang.Thread(task);
        java.lang.Thread t2 = new Thread(task);
        t1.start();
        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Final count (Synchronized): " + counter.getCount());
    }
}
