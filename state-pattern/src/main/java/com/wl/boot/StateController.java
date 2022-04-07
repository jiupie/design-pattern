package com.wl.boot;

import com.wl.boot.enums.BlobEventEnum;
import com.wl.boot.enums.UpStateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/state")
public class StateController {

    @Autowired
    private StateMachine<UpStateEnum, BlobEventEnum> stateMachine;

    @GetMapping
    public String stateRun() {
        // start()就是创建这个up主的发博客流程，根据之前的定义，该up会处于不经常更新（SOMETIME）状态
        stateMachine.start();
        // 通过调用sendEvent(Events.THROW_COIN)执行投币操作
        stateMachine.sendEvent(BlobEventEnum.THROW_COIN);
        // 通过调用sendEvent(Events.THROW_COIN)执行点赞操作
        stateMachine.sendEvent(BlobEventEnum.LIKE);
        // 通过调用sendEvent(Events.THROW_COIN)执行收藏操作
        stateMachine.sendEvent(BlobEventEnum.COLLECT);
        return "OK";
    }

}
