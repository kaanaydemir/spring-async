# Java Concurrency Examples

This repository contains illustrative examples of various Java concurrency mechanisms to help developers better understand and harness the power of multi-threading and parallel processing in Java applications.

## Table of Contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Examples](#examples)
    - [Semaphore](#semaphore)
    - [CyclicBarrier](#cyclicbarrier)
    - [CountDownLatch](#countdownlatch)
    - [CompletableFuture](#completableFuture)
4. [How to Run](#how-to-run)


## Introduction

Concurrency can greatly enhance the performance of applications but it also brings its own set of challenges. This repository aims to provide clear examples of various Java concurrency mechanisms to help bridge the gap between theory and practice.

## Prerequisites

- Java JDK 8 or later
- Maven (optional)

## Examples

### Semaphore

A semaphore is a synchronization mechanism that controls the number of threads that can access a resource or perform a particular action at the same time.

[See Semaphore Example](https://github.com/kaanaydemir/spring-async/blob/master/src/main/java/com/kaanaydemir/springasync/services/SemaphoreExample.java)

### CyclicBarrier

CyclicBarrier is a synchronization aid that allows a group of threads to wait for each other to reach a common barrier point.

[See CyclicBarrier Example](https://github.com/kaanaydemir/spring-async/blob/master/src/main/java/com/kaanaydemir/springasync/services/CyclicBarrierExample.java)

### CountDownLatch

CountDownLatch is a synchronization aid that allows one or more threads to wait until a set of operations being performed by other threads completes.

[See CountDownLatch Example](https://github.com/kaanaydemir/spring-async/blob/master/src/main/java/com/kaanaydemir/springasync/services/CountDownLatchExample.java)

### CompletableFuture

A modern and powerful way to handle asynchronous computations in Java.

[See CompletableFuture Example](https://github.com/kaanaydemir/spring-async/blob/master/src/main/java/com/kaanaydemir/springasync/services/ExampleService.java)


## How to Run

1. Clone the repository:

```bash
git clone https://github.com/your-username/java-concurrency-examples.git
```


Happy Coding!