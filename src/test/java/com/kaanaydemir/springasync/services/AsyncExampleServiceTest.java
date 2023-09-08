package com.kaanaydemir.springasync.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsyncExampleServiceTest {


    @Autowired
    private AsyncExampleService asyncExampleService;

    @Test
    void printHello() {
        asyncExampleService.printHello();
    }

    @Test
    void handleString() {
        asyncExampleService.handleString("Hello");
    }
}