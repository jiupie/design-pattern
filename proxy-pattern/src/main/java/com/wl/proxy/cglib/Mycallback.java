package com.wl.proxy.cglib;

import com.wl.proxy.jdk.MyShopping;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/8/28
 */
public class Mycallback implements MethodInterceptor {
    private MyShopping shopping;

    public Mycallback(MyShopping shopping) {
        this.shopping = shopping;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("money...");
        Object invoke = method.invoke(shopping, objects);
        return invoke;
    }
}
