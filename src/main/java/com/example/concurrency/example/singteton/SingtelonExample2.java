package com.example.concurrency.example.singteton;

import com.example.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
public class SingtelonExample2 {
    private SingtelonExample2() {
        //如果进行了一系列操作可能会出现类加载比较慢
    }

    private static SingtelonExample2 instance = new SingtelonExample2();

    public static SingtelonExample2 getInstance() {
        return instance;
    }
}
