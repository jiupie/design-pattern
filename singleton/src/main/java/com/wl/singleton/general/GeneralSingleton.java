package com.wl.singleton.general;

/**
 * @author 南顾北衫
 * @description 普通的饿汉式单例
 * @date 2022/9/3
 */
public class GeneralSingleton {
    /**
     * 类加载时 进行实例化 jvm视角下的<clInit>方法加载
     */
    private static final GeneralSingleton INSTANCE = new GeneralSingleton();

    /**
     * 私有化构造函数，防止外部new对象
     */
    private GeneralSingleton() {

    }

    public static GeneralSingleton getInstance() {
        return INSTANCE;
    }

}
