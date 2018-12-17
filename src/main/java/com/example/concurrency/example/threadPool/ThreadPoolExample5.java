package com.example.concurrency.example.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadPoolExample5 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.schedule(() -> log.info("schedule run"), 3, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> log.info("scheduleAtFixedRate run"), 1, 1, TimeUnit.SECONDS);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("timer run");
            }
        }, new Date(), 1000);
//        executorService.shutdown();
    }
}
