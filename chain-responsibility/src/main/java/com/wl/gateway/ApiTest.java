package com.wl.gateway;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式
 *
 * @author 南顾北衫
 */
public class ApiTest {
    public static void main(String[] args) {
        //配置过滤器
        List<MyFilter> filters = new ArrayList();
        filters.add(new BlackListFilter());
        filters.add(new IPFilter());


        VirtualFilterChain virtualFilterChain = new VirtualFilterChain(filters);

        virtualFilterChain.doFilter("http://www.baidu.com");
        System.out.println("=======================================");


        VirtualFilterChain virtualFilterChain1 = new VirtualFilterChain(filters);
        virtualFilterChain1.doFilter("httpas://www.baidu.com");
    }
}
