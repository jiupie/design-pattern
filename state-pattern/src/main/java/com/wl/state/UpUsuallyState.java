package com.wl.state;

/**
 * @author 南顾北衫
 */
public class UpUsuallyState extends Upstate {
    @Override
    protected void doAction() {
        System.out.println("状态：usually");

    }

    @Override
    protected void switchState() {

        // 执行动作
        stateContext.getUpstate().doAction();
    }
}
