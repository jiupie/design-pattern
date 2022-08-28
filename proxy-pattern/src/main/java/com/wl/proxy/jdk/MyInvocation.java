package com.wl.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/8/28
 */
public class MyInvocation implements InvocationHandler {
    private MyShopping myShopping;

    public MyInvocation(MyShopping myShopping) {
        this.myShopping = myShopping;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("money:" + args[0]);
        Object res = method.invoke(myShopping, args);
        return res;
    }
}
