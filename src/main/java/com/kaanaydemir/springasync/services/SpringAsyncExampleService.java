package com.kaanaydemir.springasync.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class SpringAsyncExampleService {

    @Async
    public void printHello() {
        try {
            System.out.println("Hello from " + Thread.currentThread().getName() + " thread" + " with " + Thread.currentThread().getId() + " id");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Async
    public CompletableFuture<String> handleString(String s){
        System.out.println("Hello from " + Thread.currentThread().getName() + " thread" + " with " + Thread.currentThread().getId() + " id");
        return CompletableFuture.completedFuture(s);
    }
}
