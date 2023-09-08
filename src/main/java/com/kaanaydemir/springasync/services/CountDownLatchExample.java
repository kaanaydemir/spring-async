package com.kaanaydemir.springasync.services;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    private static final int NUMBER_OF_WORKERS = 20;
    private static final CountDownLatch latch = new CountDownLatch(NUMBER_OF_WORKERS);

    public void countDownLatchExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            executorService.execute(() -> countDownLatch(finalI));
        }

        try {
            System.out.println("Waiting for all workers to finish processing...");
            latch.await();
            System.out.println("All workers have finished processing.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

    }

    private void countDownLatch(int i) {
        try {
            System.out.println("Worker " + i + " is processing...");
            Thread.sleep((int) (Math.random() * 1000));
            System.out.println("Worker " + i + " has finished processing.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // Decrement the count of the latch.
        }
    }
}
