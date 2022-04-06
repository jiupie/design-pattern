package com.wl.gateway;

import java.util.List;

/**
 * VirtualFilterChain vfc = new VirtualFilterChain(fwRequest, chain, filters);
 *
 * @author 南顾北衫
 */
public class VirtualFilterChain implements MyFilterChain {


    private List<MyFilter> additionalFilters;
    private final int size;
    private int currentPosition = 0;


    public VirtualFilterChain(List<MyFilter> additionalFilters) {

        this.additionalFilters = additionalFilters;
        this.size = additionalFilters.size();

    }

    @Override
    public void doFilter(String value) {
        if (currentPosition != size) {
            currentPosition++;
            MyFilter nextFilter = additionalFilters.get(currentPosition - 1);
            nextFilter.doFilter(value, this);
        } else {
            System.out.println("过滤器已经走完");
        }
    }
}
