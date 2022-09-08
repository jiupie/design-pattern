package com.wl.singleton;

/**
 * @author 南顾北衫
 * @description 不安全的懒汉
 * @date 2022/9/3
 */
public class SingletonTwo {
    private static SingletonTwo INSTANCE;

    private SingletonTwo() {

    }


    public static SingletonTwo getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new SingletonTwo();
        }
        return INSTANCE;
    }
}
