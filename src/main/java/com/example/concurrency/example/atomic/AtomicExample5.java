package com.example.concurrency.example.atomic;

import com.example.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

@Slf4j
@ThreadSafe
public class AtomicExample5 {

    private static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 atomicExample5 = new AtomicExample5();
        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("success 1 count: " + atomicExample5.getCount());
        }

        if (updater.compareAndSet(atomicExample5, 100, 120)) {
            log.info("success 2 count: " + atomicExample5.getCount());
        } else {
            log.info("failed count: " + atomicExample5.getCount());
        }
    }

}
