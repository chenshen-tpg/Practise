package CompanySpecific.Canava.ProgrammingQuestions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Thread {

    public static void main(String args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Executing task " + taskId + " on thread: " + java.lang.Thread.currentThread().getName());
                try {
                    java.lang.Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    System.err.println("Task " + taskId + " was interrupted.");
                    java.lang.Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();

        if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
            System.err.println("Executor did not terminate in the allotted time. Forcing shutdown...");
            executor.shutdownNow();
        }

        System.out.println("All tasks completed.");
    }
}
