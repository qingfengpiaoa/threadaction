package com.cjk;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=10m
 * 元空间大小
 */
public class MetaspaceOOMTest {


    static class OOMTest {
    }

    public static void main(String[] args) {
        int i = 0; //模拟计数多少次

        try {
            while (true) {
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                enhancer.create();
            }

        } catch (Exception e) {
            System.out.println("****第多少次后空间满了"+i);
            e.printStackTrace();
        }
    }
}
