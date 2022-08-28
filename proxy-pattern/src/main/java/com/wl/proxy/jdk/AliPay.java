package com.wl.proxy.jdk;

import java.lang.reflect.Member;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/8/28
 */
public class AliPay implements MyShopping{
    @Override
    public String pay(Integer money) {
        return "ali:"+ money;
    }
}
