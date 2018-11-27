package com.example.concurrency.example.singteton;

import com.example.concurrency.annoations.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
public class SingtelonExample7 {
    private SingtelonExample7() {
        //如果进行了一系列操作可能会出现类加载比较慢
    }

    private static SingtelonExample7 instance = null;

    static {
        instance = new SingtelonExample7();
    }


    public static SingtelonExample7 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
