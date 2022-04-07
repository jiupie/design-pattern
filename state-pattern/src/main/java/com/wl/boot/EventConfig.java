package com.wl.boot;

import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionEnd;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * @program: guess
 * @description: 该配置实现了cn.guess.statemachine.tow.config.StateMachineConfig类中定义的状态机监听器实现
 * @author: xingcheng
 * @create: 2020-05-10 16:31
 **/
@WithStateMachine
public class EventConfig {

    @OnTransition(target = "UP_SOMETIMES_STATE")
    public void initState() {
        System.out.println("up sometime update blob");
    }

    @OnTransition(source = "UP_SOMETIME_STATE", target = "UP_OFTEN_STATE")
    public void throwCoin() {
        System.out.println("up sometime update blob");
    }

    @OnTransitionStart(source = "UP_SOMETIME_STATE", target = "UP_OFTEN_STATE")
    public void throwCoinStart() {
        System.out.println("up sometime update blob start");
    }

    @OnTransitionEnd(source = "UP_SOMETIME_STATE", target = "UP_OFTEN_STATE")
    public void throwCoinEnd() {
        System.out.println("up sometime update blob end");
    }

    @OnTransition(source = "UP_OFTEN_STATE", target = "UP_USUALLY_STATE")
    public void like() {
        System.out.println("user like blob, up usually update blob");
    }

    @OnTransition(source = "UP_USUALLY_STATE", target = "UP_ALWAYS_STATE")
    public void collect() {
        System.out.println("user collect blob, up always update blob");
    }

}

