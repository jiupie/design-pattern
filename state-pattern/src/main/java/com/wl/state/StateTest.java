package com.wl.state;

/**
 * @author 南顾北衫
 */
public class StateTest {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext();
        stateContext.throwCoin();

        stateContext.like();

        stateContext.collect();
    }
}
