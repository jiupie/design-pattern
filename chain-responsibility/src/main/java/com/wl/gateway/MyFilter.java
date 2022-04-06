package com.wl.gateway;

/**
 * @author 南顾北衫
 */
public interface MyFilter {
    void doFilter(String value, MyFilterChain chain);
}
