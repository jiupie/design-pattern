package com.wl;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/9/1
 */
public interface SecurityBuilder<O> {
    /**
     * 构造一个对象
     * @return
     */
    O build();
}
