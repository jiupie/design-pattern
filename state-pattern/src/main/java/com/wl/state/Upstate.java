package com.wl.state;

/**
 * @author 南顾北衫
 */
public abstract class Upstate {
    protected StateContext stateContext;

    /**
     * 该状态下的操作
     */
    protected abstract void doAction();

    /**
     * 切换状态
     */
    protected abstract void switchState();

}
