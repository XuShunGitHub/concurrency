package com.example.concurrency.example.error;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 栈内存溢出（可能会导致操作系统假死）
 * -Xss2m
 */
@Slf4j
public class StackOOM {
    @Getter
    private int theadCount = 0;

    public void addThead() {
        while (true) {//不停创建新线程
            theadCount++;
            new Thread(() -> {
                while (true) ;//每个线程都不停执行，导致线程总占用内存溢出
            }).start();
        }
    }

    public static void main(String[] args) {
        StackOOM stackOOM = new StackOOM();
        try {
            stackOOM.addThead();
        } catch (Throwable e) {
            log.info("theadCount: {}", stackOOM.getTheadCount());
            log.error("error: ", e);
        }
    }
}
