package com.wl.proxy.cglib;

import com.wl.proxy.jdk.AliPay;
import com.wl.proxy.jdk.MyShopping;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/8/28
 */
public class CglibDemo {
    public static void main(String[] args) {
        MyShopping aliPay = new AliPay();

        Enhancer enhancer = new Enhancer();
        Mycallback mycallback = new Mycallback(aliPay);
        enhancer.setCallback(mycallback);

        enhancer.setSuperclass(aliPay.getClass());
        MyShopping o = (MyShopping) enhancer.create();
        o.pay(23);
    }
}
