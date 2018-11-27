package com.example.concurrency.example.singteton;

import com.example.concurrency.annoations.NotThreadSafe;

/**
 * 懒汉模式
 */
@NotThreadSafe
public class SingtelonExample1 {
    private SingtelonExample1() {
        //如果进行了一系列操作可能会出现线程不安全
    }

    private static SingtelonExample1 instance = null;

    public static SingtelonExample1 getInstance() {
        if (instance == null) {//线程不安全
            instance = new SingtelonExample1();
        }
        return instance;
    }
}
