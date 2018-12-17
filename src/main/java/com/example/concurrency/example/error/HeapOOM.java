package com.example.concurrency.example.error;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 推内存溢出异常
 * -Xms100m
 * -Xmx200m
 * -XX:+HeapDumpOnOutOfMemoryError
 */
@Slf4j
public class HeapOOM {
    static class OOMObject{
    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        try {
            while (true) {
                list.add(new OOMObject());
            }
        } catch (Throwable e) {
            log.info("list size: {}", list.size());
            log.error("error: ", e);
        }
    }
}
