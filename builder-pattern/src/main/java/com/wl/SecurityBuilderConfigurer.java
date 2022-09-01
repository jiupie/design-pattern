package com.wl;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/9/1
 */
public interface SecurityBuilderConfigurer<O, B extends SecurityBuilder<O>> {
    void init(B builder);

    void configure(B builder);
}
