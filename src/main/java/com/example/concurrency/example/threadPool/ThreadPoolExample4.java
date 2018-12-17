package com.example.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolExample4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executorService.execute(()->{
                log.info("task: {}", index);
            });
        }
        executorService.shutdown();
    }
}
