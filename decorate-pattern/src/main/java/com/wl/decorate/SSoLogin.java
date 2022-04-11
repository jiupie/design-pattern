package com.wl.decorate;

/**
 * @author 南顾北衫
 */
public class SSoLogin implements Intercept {


    @Override
    public boolean handle(String value) {
        if (value.contains("a")) {
            System.out.println("sso登录成功");
            return true;
        } else {
            System.err.println("sso登录失败");
            return false;
        }
    }
}
