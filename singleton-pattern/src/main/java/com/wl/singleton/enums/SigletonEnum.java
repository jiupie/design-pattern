package com.wl.singleton.enums;

/**
 * 枚举类实现单例
 *
 * @author 南顾北衫
 * @description
 * @date 2022/9/3
 */
public enum SigletonEnum {

    X;

    public String s(String name) {
        System.out.println(name);
        return name;
    }
}
