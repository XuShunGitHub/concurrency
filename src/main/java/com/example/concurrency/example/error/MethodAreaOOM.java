package com.example.concurrency.example.error;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 方法区（云空间）内存溢出
 * -XX:PermSize=10m -XX:MaxPermSize=10（JDK7）
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m（JDK8）
 */
public class MethodAreaOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(objects, args));
            enhancer.create();
        }

    }

}
