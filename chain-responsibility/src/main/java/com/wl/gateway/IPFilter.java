package com.wl.gateway;

/**
 * @author 南顾北衫
 */
public class IPFilter implements MyFilter {


    @Override
    public void doFilter(String value, MyFilterChain chain) {
        System.out.println("ip责任链：" + value);
        chain.doFilter(value);
    }
}
