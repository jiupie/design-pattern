package com.wl.state;

/**
 * @author 南顾北衫
 */
public class UpAlwaysState  extends Upstate {
    @Override
    protected void doAction() {
        System.out.println("状态：always");
    }

    @Override
    protected void switchState() {
        //转变状态
        stateContext.setUpstate(stateContext.getUpUsuallyState());
        // 执行动作
        stateContext.getUpstate().doAction();
    }
}
