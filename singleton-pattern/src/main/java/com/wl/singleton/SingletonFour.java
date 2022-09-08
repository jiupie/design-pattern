package com.wl.singleton;

/**
 * @author 南顾北衫
 * @description 静态内部类
 * @date 2022/9/3
 */
public class SingletonFour {

    private SingletonFour() {
    }

    private static class Singleton {
        private static final SingletonFour INSTANCE = new SingletonFour();
    }


    public static SingletonFour getInstance() {
        return Singleton.INSTANCE;
    }
}
