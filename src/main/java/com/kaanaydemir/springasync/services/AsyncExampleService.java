package com.kaanaydemir.springasync.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncExampleService {

    private final SpringAsyncExampleService springAsyncExampleService;

    public AsyncExampleService(SpringAsyncExampleService springAsyncExampleService) {
        this.springAsyncExampleService = springAsyncExampleService;
    }

    public void printHello() {
        for (int i = 0; i < 10; i++) {
            springAsyncExampleService.printHello();
        }
    }

    public void handleString(String s) {
        List<CompletableFuture<String>> completableFutureList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            CompletableFuture<String> completableFuture = springAsyncExampleService.handleString(s);
            completableFutureList.add(completableFuture);
        }

        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
    }
}
