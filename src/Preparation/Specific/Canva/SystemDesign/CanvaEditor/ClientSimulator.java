package Preparation.Specific.Canva.SystemDesign.CanvaEditor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClientSimulator {
    public static void main(String[] args) throws InterruptedException {
        SharedDocument document = new SharedDocument("Initial document.");
        ExecutorService executor = Executors.newFixedThreadPool(5); // 5 concurrent clients
        // Simulate multiple readers and writers
        executor.submit(() -> document.readContent("Reader-A"));
        executor.submit(() -> document.appendContent("Writer-1", " Hello."));
        executor.submit(() -> document.readContent("Reader-B"));
        executor.submit(() -> document.appendContent("Writer-2", " World!"));
        executor.submit(() -> document.readContent("Reader-C"));
        executor.submit(() -> document.replaceContent("Writer-3", "Brand new content."));
        executor.submit(() -> document.readContent("Reader-D"));
        executor.submit(() -> document.appendContent("Writer-4", " The End."));
        executor.submit(() -> document.readContent("Reader-E"));
        executor.submit(() -> document.readContent("Reader-F"));
        executor.shutdown();
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.err.println("Some tasks did not complete.");
        }

        System.out.println("\nFinal Document Content: \"" + document.readContent("Main Thread") + "\"");
    }
}