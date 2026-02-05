package CodingQuestions.Algorithms.Important.RandomQuestions.Compare1MdataIn20Sec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Compare1MData {
        private static final int THREAD_POOL_SIZE = 8;
        private static final int BATCH_SIZE = 50000;
        private static final BlockingQueue<List<DataRow>> dataQueue = new LinkedBlockingQueue<>();
        private static final ConcurrentHashMap<String, String> db1Hashes = new ConcurrentHashMap<>();

        public void compareData() throws InterruptedException {
            ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
            AtomicInteger recordsProcessed = new AtomicInteger(0);

            // Producer thread to load data from DB1 and hash it
            new Thread(() -> {
                try {
                    // Read from Database 1 in chunks
                    List<DataRow> batch = fetchFromDB1(BATCH_SIZE);
                    for (DataRow row : batch) {
                        db1Hashes.put(row.getId(), hashRow(row));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            // Producer thread to load data from DB2
            new Thread(() -> {
                try {
                    while (recordsProcessed.get() < 1000000) {
                        List<DataRow> batch = fetchFromDB2(BATCH_SIZE);
                        dataQueue.put(batch);
                        recordsProcessed.addAndGet(batch.size());
                    }
                    dataQueue.put(Collections.emptyList()); // Sentinel to signal end
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

            // Consumer threads to compare data
            for (int i = 0; i < THREAD_POOL_SIZE; i++) {
                executor.submit(() -> {
                    try {
                        while (true) {
                            List<DataRow> batch = dataQueue.take();
                            if (batch.isEmpty()) {
                                dataQueue.put(Collections.emptyList()); // Pass sentinel
                                break;
                            }
                            for (DataRow row : batch) {
                                String db1Hash = db1Hashes.get(row.getId());
                                String db2Hash = hashRow(row);
                                if (db1Hash == null || !db1Hash.equals(db2Hash)) {
                                    System.out.println("Mismatch found for ID: " + row.getId());
                                }
                            }
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS);
        }

    private String hashRow(DataRow row) {
        return "Hash";
    }

    private List<DataRow> fetchFromDB2(int batchSize) {
        return new ArrayList<>();
    }

    private List<DataRow> fetchFromDB1(int batchSize) {
            return new ArrayList<>();
    }

}
