package com.wl.proxy.jdk;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/8/28
 */
public class JdkProxyDemo {
    public static void main(String[] args) {

        AliPay s = new AliPay();
        MyShopping myShopping = (MyShopping) Proxy.newProxyInstance(s.getClass().getClassLoader(), s.getClass().getInterfaces(), new MyInvocation(s));
        System.out.println(myShopping.pay(223));

        System.out.println(Arrays.toString(MyShopping.class.getInterfaces()));

        //接口 无实现类
        MyShopping myShopping1 = (MyShopping) Proxy.newProxyInstance(MyShopping.class.getClassLoader(), new Class[]{MyShopping.class}, new MyInvocationInter());
        System.out.println(myShopping1.pay(1));
    }
}
