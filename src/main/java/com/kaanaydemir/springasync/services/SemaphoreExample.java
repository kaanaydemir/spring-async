package com.kaanaydemir.springasync.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample {

    private static final int MAX_CONCURRENT_THREADS = 3;
    private final Semaphore semaphore = new Semaphore(MAX_CONCURRENT_THREADS);


    public void callSemapHore() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int userNumber = i;
            Thread thread = new Thread(() -> useResource(userNumber));
            thread.start();
            threadList.add(thread);
        }

        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



    }

    public void useResource(int userNumber) {
        try {
            System.out.println("User " + userNumber + " trying to acquire the resource...");
            semaphore.acquire();
            System.out.println("User " + userNumber + " acquired the resource.");

            // Simulating some work with the resource
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("User " + userNumber + " released the resource.");
            semaphore.release();
        }
    }
}
