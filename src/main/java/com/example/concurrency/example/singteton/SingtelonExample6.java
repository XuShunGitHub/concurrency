package com.example.concurrency.example.singteton;

import com.example.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式 -> 双重检测机制
 */
@ThreadSafe
public class SingtelonExample6 {
    private SingtelonExample6() {
    }

    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存


    // volatile + 双重检测机制 -> 禁止指令重排
    private static volatile SingtelonExample6 instance = null;

    public synchronized static SingtelonExample6 getInstance() {
        if (instance == null) {//双重检测机制 //B线程
            synchronized (SingtelonExample6.class) {//同步锁
                if (instance == null) {
                    instance = new SingtelonExample6(); //A线程
                }
            }
        }
        return instance;
    }
}
