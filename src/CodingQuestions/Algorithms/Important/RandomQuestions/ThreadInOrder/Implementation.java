package CodingQuestions.Algorithms.Important.RandomQuestions.ThreadInOrder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Implementation {
    public static void main(String[] args) {

    }
    public void joinMethod() {
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is running.");
        });
        Thread thread2 = new Thread(() -> {
            try {
                thread1.join();
                System.out.println("Thread 2 is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
    public void countDown() {
        final CountDownLatch latch = new CountDownLatch(1);
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is running.");
            latch.countDown();
        });
        Thread thread2 = new Thread(() -> {
            try {
                latch.await();
                System.out.println("Thread 2 is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        thread1.start();
    }
    public void semaphore() {
        final Semaphore semaphore = new Semaphore(0);
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 is running.");
            // Release a permit, opening the gate
            semaphore.release();
        });

        Thread thread2 = new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("Thread 2 is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread2.start();
        thread1.start();
    }
}
