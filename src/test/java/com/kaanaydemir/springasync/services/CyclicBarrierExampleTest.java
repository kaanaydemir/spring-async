package com.kaanaydemir.springasync.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CyclicBarrierExampleTest {

    private static CyclicBarrierExample cyclicBarrierExample;

    @BeforeAll
    static void setUp() {
        cyclicBarrierExample = new CyclicBarrierExample();
    }

    @Test
    void cyclicBarrierExample() {
        cyclicBarrierExample.handleCyclicBarrierExample();
    }
}