package com.wl.state;

/**
 * @author 南顾北衫
 */
public class UpSometimesState extends Upstate {
    @Override
    protected void doAction() {
        System.out.println("状态为：sometime");
    }

    @Override
    protected void switchState() {
        //转变状态
         stateContext.setUpstate(stateContext.getUpOftenState());
        // 执行动作
        stateContext.getUpstate().doAction();
    }
}
