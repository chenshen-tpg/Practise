package Preparation.Specific.Canva.SystemDesign.CanvaEditor;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.TimeUnit; // For Thread.sleep

public class SharedDocument {


    private final AtomicReference<String> content = new AtomicReference<>("");
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public SharedDocument(String initialContent) {
        this.content.set(initialContent);
        System.out.println("Document initialized with: \"" + initialContent + "\"");
    }

    /**
     * Reads the current content of the document. Multiple readers can access concurrently.
     * @return The current document content.
     */
    public String readContent(String readerId) {
        readLock.lock(); // Acquire read lock
        try {
            String currentContent = content.get();
            System.out.println(readerId + " is reading: \"" + currentContent + "\"");
            // Simulate some read processing time
            TimeUnit.MILLISECONDS.sleep(50);
            return currentContent;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        } finally {
            readLock.unlock(); // Release read lock
        }
    }

    /**
     * Appends text to the document. Only one writer can access at a time, blocking readers.
     * @param writerId The ID of the writer.
     * @param textToAppend The text to append.
     */
    public void appendContent(String writerId, String textToAppend) {
        writeLock.lock(); // Acquire write lock
        try {
            String oldContent = content.get();
            String newContent = oldContent + textToAppend;
            content.set(newContent); // Atomically update the content
            System.out.println(writerId + " appended: \"" + textToAppend + "\". New content: \"" + newContent + "\"");
            // Simulate some write processing time
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock(); // Release write lock
        }
    }

    /**
     * Replaces the content of the document. Only one writer can access at a time, blocking readers.
     * @param writerId The ID of the writer.
     * @param newText The new content for the document.
     */
    public void replaceContent(String writerId, String newText) {
        writeLock.lock(); // Acquire write lock
        try {
            String oldContent = content.get();
            content.set(newText); // Atomically update the content
            System.out.println(writerId + " replaced content. Old: \"" + oldContent + "\", New: \"" + newText + "\"");
            // Simulate some write processing time
            TimeUnit.MILLISECONDS.sleep(150);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            writeLock.unlock(); // Release write lock
        }
    }
}
