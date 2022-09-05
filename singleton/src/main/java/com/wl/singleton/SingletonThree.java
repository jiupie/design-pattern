package com.wl.singleton;

/**
 * @author 南顾北衫
 * @description DCL
 * @date 2022/9/3
 */
public class SingletonThree {
    private volatile static SingletonThree INSTANCE;

    private SingletonThree() {

    }

    public static SingletonThree getInstance() {
        if (INSTANCE == null) {
            synchronized (SingletonThree.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonThree();
                }
            }
        }
        return INSTANCE;
    }

}
