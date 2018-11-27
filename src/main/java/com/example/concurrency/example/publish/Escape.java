package com.example.concurrency.example.publish;

import com.example.concurrency.annoations.NotRecommend;
import com.example.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeEscape = 0;
    public Escape(){
        //对象未初始化完成，不能启动线程，否则会出现对象逸出，应指定方法统一启动
        new InnerClass();
    }
    private class InnerClass {
        public InnerClass(){
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }


}
