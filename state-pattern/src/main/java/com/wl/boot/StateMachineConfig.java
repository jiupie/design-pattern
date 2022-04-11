package com.wl.boot;

import com.wl.boot.enums.BlobEventEnum;
import com.wl.boot.enums.UpStateEnum;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

/**
 * @author 南顾北衫
 */
@EnableStateMachine
@Component
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<UpStateEnum, BlobEventEnum> {
    @Override
    public void configure(StateMachineStateConfigurer<UpStateEnum, BlobEventEnum> states) throws Exception {
        states.withStates().initial(UpStateEnum.UP_SOMETIMES_STATE).states(EnumSet.allOf(UpStateEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<UpStateEnum, BlobEventEnum> transitions) throws Exception {
        transitions.withExternal()
                // 投币：UpSometimeState -> UpOftenState
                .source(UpStateEnum.UP_SOMETIMES_STATE).target(UpStateEnum.UP_OFTEN_STATE).event(BlobEventEnum.THROW_COIN).and().withExternal()
                // 点赞：UpOftenState -> UpUsuallyState
                .source(UpStateEnum.UP_OFTEN_STATE).target(UpStateEnum.UP_USUALLY_STATE).event(BlobEventEnum.LIKE).and().withExternal()
                // 收藏：UpUsuallyState -> UpAlwaysState
                .source(UpStateEnum.UP_USUALLY_STATE).target(UpStateEnum.UP_ALWAYS_STATE).event(BlobEventEnum.COLLECT);
    }
}
