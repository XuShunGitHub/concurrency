package com.example.concurrency.example.error;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池内存溢出
 * -XX:PermSize=10m -XX:MaxPermSize=10m（JDK7以下，JDK8无效）
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m（JDK8已移除永久代，采用云空间存储，XX:MaxMetaspaceSize，最大空间，默认是没有限制的）
 */
public class RuntimeConstantPoolOOM {
    static String base = "String";

    public static void main(String[] args) {
        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        while (true) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
//        String str1 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str1.intern() == str1);//首次出现，true
//        String str2 = new StringBuilder("ja").append("va").toString();
//        System.out.println(str2.intern() == str2);//常量池中已存在，false
//        String str3 = new StringBuilder("计算机").append("软件").toString();
//        System.out.println(str3.intern() == str3);//常量池中已存在，false
    }
}
