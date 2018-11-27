package com.example.concurrency.example.singteton;

import com.example.concurrency.annoations.NotRecommend;
import com.example.concurrency.annoations.NotThreadSafe;
import com.example.concurrency.annoations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
@NotRecommend
public class SingtelonExample3 {
    private SingtelonExample3() {
    }

    private static SingtelonExample3 instance = null;

    public synchronized static SingtelonExample3 getInstance() {
        //只有一个线程能执行，存在性能问题
        if (instance == null) {
            instance = new SingtelonExample3();
        }
        return instance;
    }
}
