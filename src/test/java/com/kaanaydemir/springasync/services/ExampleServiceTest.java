package com.kaanaydemir.springasync.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ExampleServiceTest {

    private static ExampleService exampleService;
    private static SemaphoreExample semaphoreExample;
    private static CountDownLatchExample countDownLatchExample;

    @BeforeAll
    static void setUp() {
        exampleService = new ExampleService();
        semaphoreExample = new SemaphoreExample();
        countDownLatchExample = new CountDownLatchExample();
    }

    @Test
    void newFixedThreadPoolExample() {
        exampleService.newFixedThreadPoolExample();
    }

    @Test
    void newFixedThreadPoolWaitForTheThreadComplete() {
        exampleService.newFixedThreadPoolWaitForTheThreadComplete();
    }

    @Test
    void ThreadPoolExecutorExample() {
        exampleService.ThreadPoolExecutorExample();
    }

    @Test
    void callableExample() {
        exampleService.callableExample();
    }

    @Test
    void compleTableFutureExample() {
        exampleService.compleTableFutureExample();
    }

    @Test
    void compleTableFutureExample2() {
        exampleService.completeTableFutureWithExceptionExample();
    }

    @Test
    void compleTableFutureExample3() {
        exampleService.threadExample();
    }

    @Test
    void callSemaphore() {
        semaphoreExample.callSemapHore();
    }

    @Test
    void countDownLatchExample() {
        countDownLatchExample.countDownLatchExample();
    }

}