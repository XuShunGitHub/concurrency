package com.example.concurrency.example.singteton;

import com.example.concurrency.annoations.Recommend;
import com.example.concurrency.annoations.ThreadSafe;

/**
 * 枚举模式 - 最安全
 */
@ThreadSafe
@Recommend
public class SingtelonExample8 {

    private SingtelonExample8() {
    }
    public static SingtelonExample8 getInstance() {
        return Singtelon.INSTANCE.getInstance();
    }

    private enum Singtelon {
        INSTANCE;
        private SingtelonExample8 instance = null;

        // JVM保证这个方法绝对只调用一次，而且调用的时候才初始化
        Singtelon() {
            instance = new SingtelonExample8();
        }

        public SingtelonExample8 getInstance() {
            return instance;
        }
    }


    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
