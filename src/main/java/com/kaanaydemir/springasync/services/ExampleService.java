package com.kaanaydemir.springasync.services;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.*;

@Service
public class ExampleService {

    private final Random random = new Random();


    public void threadExample() {
        Thread thread = new Thread(this::printHello);
        Thread thread1 = new Thread(this::printHello);
        thread.start();
        thread1.start();
    }

    //This Run the method 10 times in 10 different threads
    public void newFixedThreadPoolExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(this::printHello);
        }
    }

    //This method run the method in 1 thread and wait for the thread complete
    public void newFixedThreadPoolWaitForTheThreadComplete() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(this::printHelloLoop);
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void ThreadPoolExecutorExample() {
        ExecutorService executorService = new ThreadPoolExecutor(1,
                                                                 100,
                                                                 1000L,
                                                                 TimeUnit.MILLISECONDS,
                                                                 new LinkedBlockingQueue<>(1));
        for (int i = 0; i < 20; i++) {
            executorService.execute(this::printHelloWithSleep);
        }

        try {
            executorService.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void callableExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<Integer> future = executorService.submit(this::getInt);
        while (!future.isDone()) {
            System.out.println("Waiting for the task to complete");
        }
        System.out.println("Task completed");
    }

    public void compleTableFutureExample() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::getInt);
        completableFuture.thenAccept(this::printInt);
    }

    public void completeTableFutureWithExceptionExample() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(this::getInt);
        completableFuture
                .thenApply(this::handleInt)
                .thenAccept(this::printInt)
                .exceptionally(throwable -> {
                    System.out.println("Exception occurred");
                    return null;
        });

    }
    private Integer getInt() {
        return random.nextInt(0, 20);
    }

    private void printInt(Integer integer) {
        System.out.println("Good:" + integer);
    }

    private Integer handleInt(Integer integer) {
        return (int) Math.pow(integer,2);
    }

    private void printHello() {
        System.out.println("Hello World " + Thread.currentThread().getName() + " " + Thread.currentThread().getId());
    }

    private void printHelloLoop() {
        for (int i = 0; i < 10; i++) {
            printHello();
        }
    }

    private void printHelloWithSleep() {
        try {
            Thread.sleep(5000);
            printHello();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printHello();
    }
}
