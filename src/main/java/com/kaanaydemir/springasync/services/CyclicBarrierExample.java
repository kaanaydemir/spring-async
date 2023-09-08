package com.kaanaydemir.springasync.services;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierExample {
    private static final int NUMBER_OF_TOURISTS = 5;
    private static final String[] EXHIBITS = {"Dinosaur Fossils", "Ancient Egypt", "Renaissance Art"};
    private static final int ROUNDS = 3;

    private static final CyclicBarrier exhibitBarrier = new CyclicBarrier(NUMBER_OF_TOURISTS,
                                                                           () -> System.out.println("\nAll tourists have reached the exhibit. Ready for the next exhibit!\n"));
    private static final CyclicBarrier roundBarrier = new CyclicBarrier(NUMBER_OF_TOURISTS,
                                                                        () -> System.out.println("\nAll tourists have taken a break. Ready for the next round!\n"));


    public void handleCyclicBarrierExample() {
        ExecutorService service = Executors.newFixedThreadPool(NUMBER_OF_TOURISTS);

        for (int i = 0; i < NUMBER_OF_TOURISTS; i++) {
            int finalI = i;
            service.execute(() -> cyclicBarrierExample(finalI));
        }
        service.shutdown();

        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private void cyclicBarrierExample(int id) {
        try {
            for (int round = 1; round <= ROUNDS; round++) {
                for (String exhibit : EXHIBITS) {
                    Thread.sleep((int) (Math.random() * 1000));
                    System.out.println("Tourist " + id + " has reached " + exhibit + " in round " + round + ".");
                    exhibitBarrier.await(); // Wait for all tourists to gather at each exhibit.
                }
                System.out.println("Tourist " + id + " has completed the round " + round + ".");
                roundBarrier.await(); // Wait for all tourists to finish the round and take a break.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
