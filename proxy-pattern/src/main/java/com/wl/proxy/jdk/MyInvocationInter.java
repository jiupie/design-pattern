package com.wl.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 不用原始实现类
 * @author 南顾北衫
 * @description
 * @date 2022/8/28
 */
public class MyInvocationInter implements InvocationHandler {
    public MyInvocationInter() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("money:" + args[0]);
        return "money";
    }
}
