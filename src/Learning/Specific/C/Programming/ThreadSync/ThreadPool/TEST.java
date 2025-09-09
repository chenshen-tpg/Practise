<<<<<<<< HEAD:src/Preparation/Specific/Canva/Programming/ThreadSync/ThreadPool/TEST.java
package Preparation.Specific.Canva.Programming.ThreadSync.ThreadPool;
========
package Learning.Specific.C.Programming.ThreadSync.ThreadPool;
>>>>>>>> origin/master:src/Learning/Specific/C/Programming/ThreadSync/ThreadPool/TEST.java

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



    class Task implements Runnable {
        private String name;
        public Task(String name) {
            this.name = name;
        }
        @Override
        public void run() {
            System.out.println("Executing task " + name + " on thread " + Thread.currentThread().getName());
        }
    }

    public class TEST {
        public static void main(String[] args) {
            // Create a fixed-size thread pool with 5 threads
            ExecutorService executor = Executors.newFixedThreadPool(5);

            // Submit 10 tasks to the executor
            for (int i = 0; i < 10; i++) {
                executor.submit(new Task("Task " + (i + 1)));
            }
            // Shut down the executor. This will not accept new tasks.
            executor.shutdown();
        }

}
