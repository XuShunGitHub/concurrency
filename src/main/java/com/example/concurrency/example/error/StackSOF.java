package com.example.concurrency.example.error;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 栈溢出异常
 * -Xss2m
 */
@Slf4j
public class StackSOF {
    @Getter
    private int stackLength = 0;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF stackSOF = new StackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            log.info("stackLength: {}", stackSOF.getStackLength());
            log.error("error: ", e);
        }
    }
}
