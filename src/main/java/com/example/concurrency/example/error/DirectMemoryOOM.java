package com.example.concurrency.example.error;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出
 * -Xmx20m -XX:MaxDirectMemorySize=10m
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        int i = 0;
        try {
            while (true) {
                unsafe.allocateMemory(_1MB);
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println(i);
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 /1024);
    }
}
