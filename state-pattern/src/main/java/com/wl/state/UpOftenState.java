package com.wl.state;

/**
 * @author 南顾北衫
 */
public class UpOftenState extends Upstate {
    @Override
    protected void doAction() {
        System.out.println("状态：often");
    }

    @Override
    protected void switchState() {
        //转变状态
        stateContext.setUpstate(stateContext.getUpAlwaysState());
        // 执行动作
        stateContext.getUpstate().doAction();
    }
}
