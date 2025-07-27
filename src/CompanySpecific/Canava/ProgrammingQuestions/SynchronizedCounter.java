package CompanySpecific.Canava.ProgrammingQuestions;

import java.lang.Thread;

public class SynchronizedCounter {

    private int count = 0;

    // 'synchronized' ensures only one thread can execute this method at a time
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }

    public static void main(String args) throws InterruptedException {
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

        t1.join(); // Wait for t1 to finish
        t2.join(); // Wait for t2 to finish

        System.out.println("Final count (Synchronized): " + counter.getCount());
    }
}


