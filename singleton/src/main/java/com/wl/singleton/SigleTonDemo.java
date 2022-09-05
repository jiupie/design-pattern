package com.wl.singleton;

import com.wl.singleton.enums.SigletonEnum;

/**
 * @author 南顾北衫
 * @description
 * @date 2022/9/3
 */
public class SigleTonDemo {
    public static void main(String[] args) {
        enumSigleton();

    }

    public static void enumSigleton() {
        SigletonEnum.X.s("sd");
    }
}
