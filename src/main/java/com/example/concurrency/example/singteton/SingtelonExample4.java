package com.example.concurrency.example.singteton;

import com.example.concurrency.annoations.NotRecommend;
import com.example.concurrency.annoations.NotThreadSafe;
import com.example.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式 -> 双重检测机制
 */
@NotThreadSafe
public class SingtelonExample4 {
    private SingtelonExample4() {
    }

    private static SingtelonExample4 instance = null;


    // 1、memory = allocate() 分配对象的内存空间
    // 2、ctorInstance() 初始化对象
    // 3、instance = memory 设置instance指向刚分配的内存

    // JVM和CPU优化，发生了指令重排

    // 1、memory = allocate() 分配对象的内存空间
    // 3、instance = memory 设置instance指向刚分配的内存
    // 2、ctorInstance() 初始化对象


    public synchronized static SingtelonExample4 getInstance() {
        if (instance == null) {//双重检测机制 //B线程 可能会返回一个未初始化的对象
            synchronized (SingtelonExample4.class) {//同步锁
                if (instance == null) {
                    instance = new SingtelonExample4(); //A线程 - 3
                }
            }
        }
        return instance;
    }
}
