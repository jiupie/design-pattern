package com.wl.gateway;

/**
 * @author 南顾北衫
 */
public class BlackListFilter implements MyFilter {


    @Override
    public void doFilter(String value, MyFilterChain chain) {
        if (!value.startsWith("http://")) {
            throw new RuntimeException("黑名单" + value);
        } else {
            System.out.println("黑名单 责任链：" + value);
            chain.doFilter(value);
        }
    }
}
